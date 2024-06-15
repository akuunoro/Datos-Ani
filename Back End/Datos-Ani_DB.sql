CREATE TABLE additional_costs (
  addi_cost_code INT PRIMARY KEY AUTO_INCREMENT,
  total_addi_cost DOUBLE NOT NULL
);

CREATE TABLE botanicfam (
  botanicfam_code INT PRIMARY KEY AUTO_INCREMENT,
  botanical_family VARCHAR(60) DEFAULT NULL,
  botanicfam_crops VARCHAR(60) DEFAULT NULL
);

CREATE TABLE crops_data (
  crop_code INT PRIMARY KEY AUTO_INCREMENT,
  vegetable_name VARCHAR(60) NOT NULL,
  farmer_id INT, /*FK*/
  botanical_family_id INT, /*FK*/
  plot_land_code INT, /*FK*/
  yielded_qnty INT NOT NULL,
  crop_price DOUBLE NOT NULL
);

/* 
CREATE TABLE crop_profit ( 
  crop_code INT, //CK
  farmer_id INT, //CK
  total_profit DOUBLE
);
*/

/*
CREATE TABLE crop_rotation (
  crop_code INT, //CK
  plotland_code INT, //CK
  botanicfam_code INT,
  date_harvest TIMESTAMP DEFAULT NULL,
  plant_date_agn TIMESTAMP DEFAULT NULL
);
*/


