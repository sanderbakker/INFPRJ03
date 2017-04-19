<?php

require_once(__DIR__ . '/../config.php');

class CalculatePoints {
	private $parkgarage_id;
	private $table;
	private $conn;

	private $maxPercentage;
	private $minPercentage;

	private $points;

	function __construct($parkgarage_id, $table) {
		GLOBAL $Database;

		$this->conn = $Database->getConn();
		$this->parkgarage_id = $parkgarage_id;
		$this->table 		= $table;

		$this->setMaxPercentage();
		$this->setMinPercentage();
		$this->setPoints();
	}

	private function getParkGarageInfo() {
		$select_garage_info = "SELECT * FROM parkgarage
			INNER JOIN parkgarage_address USING(parkgarage_address_id)
			LEFT JOIN parkgarage_details USING(parkgarage_code)
			WHERE parkgarage_id=$this->parkgarage_id
			";

		$result = $this->conn->query($select_garage_info);
		return $result->fetch_assoc();
	}

	private function getAvgPerYear($parkgarage_id=False, $order = 'DESC') {

		if($parkgarage_id) {
			$parkgarage_info = $this->getParkGarageInfo();
			$filter = "WHERE hood_id=$parkgarage_info[hood_id]";
		} else {
			$filter = '';
		}

		// Select AVG, MAX and MIN and group those by year.
		$select_years = "SELECT year, AVG(percentage) as avg, MAX(percentage) as max, MIN(percentage) FROM $this->table $filter GROUP BY year ORDER BY year $order";

		$result = $this->conn->query($select_years);

		$array_result = array();

		if ($result->num_rows > 0) {
		    // output data of each row
		    while($row = $result->fetch_assoc()) {
		    	$array_result[] = $row;
		    }
		} 

		return $array_result;
	}

	private function setMaxPercentage() {
		$years = $this->getAvgPerYear();
		$this->maxPercentage = ((($years[0]['max'] / 5 * 2) + 
					($years[1]['max'] / 10) + 
					($years[2]['max'] / 10) + 
					($years[3]['max'] / 10) + 
					($years[4]['max'] / 10))) +
				((($years[0]['avg'] / 5 * 2) + 
					($years[1]['avg'] / 10) + 
					($years[2]['avg'] / 10) + 
					($years[3]['avg'] / 10) + 
					($years[4]['avg'] / 10)));
	}

	/**
	*	Set the Minimum Percentage
	*/
	private function setMinPercentage() {
		$this->minPercentage = 0; // always zero
	}

	private function setPoints() {
		$years = $this->getAvgPerYear(True);

		$points =	100 - ((100 / $this->getMaxPercentage()) * 
						(($years[0]['avg'] / 5 * 2) + 
						($years[1]['avg'] / 10) + 
						($years[2]['avg'] / 10) + 
						($years[3]['avg'] / 10) + 
						($years[4]['avg'] / 10)));
		$this->points = $points / 20;
	}

	public function getMaxPercentage() {
		return $this->maxPercentage;
	}

	public function getMinPercentage() {
		return $this->minPercentage;
	}

	public function getPoints() {
		return $this->points;
	}

}

class SafetyPoints {
	private $parkgarage_id;

	private $points;

	function __construct($parkgarage_id) {
		$this->parkgarage_id = $parkgarage_id;
		$this->calcAllTables();
		$this->roundPoints();
	}

	private function calcAllTables() {
		$array 		= array();
		$theft_outof_car 		= new CalculatePoints($this->parkgarage_id, 'theft_outof_car');
		$damage_or_theft_car 	= new CalculatePoints($this->parkgarage_id, 'damage_or_theft_car');

		$array[] 	= $theft_outof_car->getPoints();
		$array[] 	= $damage_or_theft_car->getPoints();


		$count 	= 0;
		$points = 0;
		foreach($array as $value) {
			$count++;
			$points += $value;
		}

		 $this->points = $points / $count;
	}

	private function roundPoints() {
		$this->points = round($this->points, 1);
	}

	public function getPoint() {
		return $this->points;
	}

	public static function getSuggestedColor($point) {
		switch ($point) {
			case >= 4:
				$color = '#BFE57F';
				break;
			case < 4 && >= 3:
				$color = '#DFF2BF';
				break;
			case < 3 && >= 2:
				$color = '#FEEFB3';
				break;

			case < 2 && >= 1:
				$color = '#FFBABA';

				break;	
			case < 1 && >= 0:
				$color = '#FF6E6E';
				break;	

			default:
				$color = '';
				break;
		}
	}
}