CREATE TABLE farmer_info (
  farmer_id INT PRIMARY KEY AUTO_INCREMENT,
  frmr_nast_name VARCHAR(25) NOT NULL,
  frmr_first_name VARCHAR(25) NOT NULL,
  frmr_age INT NOT NULL,
  frmr_address VARCHAR (50) NOT NULL,
  frmr_emailaddress VARCHAR(50) NOT NULL,
  frmr_mobilenum VARCHAR (11) NOT NULL
);

CREATE TABLE botanicfam (
  botanicfam_code INT PRIMARY KEY AUTO_INCREMENT,
  botanical_family VARCHAR(60),
  botanicfam_crops VARCHAR(60)
);

CREATE TABLE fertilizer_data (
  fertilizer_code INT PRIMARY KEY AUTO_INCREMENT,
  name_fertilizer VARCHAR(50),
  price_fertilizer DOUBLE
);

CREATE TABLE herbicide_data (
  herbicide_code INT PRIMARY KEY AUTO_INCREMENT,
  name_herbicide VARCHAR(50),
  price_herbicide DOUBLE
);

CREATE TABLE pesticide_data (
  pesticide_code INT PRIMARY KEY AUTO_INCREMENT,
  name_pesticide VARCHAR(50),
  price_pesticide DOUBLE
);

CREATE TABLE seed_data (
  seed_code INT PRIMARY KEY AUTO_INCREMENT,
  name_seed VARCHAR (50) NOT NULL,
  price_seed DOUBLE
);

CREATE TABLE plotofland (
  plot_land_code INT PRIMARY KEY AUTO_INCREMENT,
  plfarmer_id INT, 
  date_planted DATE,
  plfertilizer_code INT, 
  plpesticide_code INT, 
  plherbicide_code INT, 
  plseed_code INT,
  
  FOREIGN KEY (plfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE SET NULL,
  FOREIGN KEY (plfertilizer_code) REFERENCES fertilizer_data (fertilizer_code) ON DELETE SET NULL,
  FOREIGN KEY (plpesticide_code) REFERENCES pesticide_data (pesticide_code) ON DELETE SET NULL,
  FOREIGN KEY (plherbicide_code) REFERENCES herbicide_data (herbicide_code) ON DELETE SET NULL,
  FOREIGN KEY (plseed_code) REFERENCES seed_data (seed_code) ON DELETE SET NULL
);

CREATE TABLE crops_data (
  crop_code INT PRIMARY KEY AUTO_INCREMENT,
  vegetable_name VARCHAR(60) NOT NULL,
  cpfarmer_id INT, 
  cpbotanicfam_code INT, 
  cpplot_land_code INT, 
  crop_rotation VARCHAR (3),
  yielded_qnty INT NOT NULL,
  crop_price DOUBLE NOT NULL,
  
  FOREIGN KEY (cpfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE SET NULL,
  FOREIGN KEY (cpbotanicfam_code) REFERENCES botanicfam (botanicfam_code) ON DELETE SET NULL,
  FOREIGN KEY (cpplot_land_code) REFERENCES plotofland (plot_land_code) ON DELETE SET NULL
);

CREATE TABLE crop_sales (
  salesfarmer_id INT, 
  salescrop_code INT, 
  total_sales DOUBLE,
  
  PRIMARY KEY (salesfarmer_id, salescrop_code),
  FOREIGN KEY (salesfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
  FOREIGN KEY (salescrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE
); 

CREATE TABLE crop_profit ( 
  profitfarmer_id INT, 
  profitcrop_code INT, 
  total_profit DOUBLE,
  
  PRIMARY KEY (profitfarmer_id, profitcrop_code),
  FOREIGN KEY (profitfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
  FOREIGN KEY (profitcrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE
);

CREATE TABLE additional_costs (
  addi_cost_code INT PRIMARY KEY AUTO_INCREMENT,
  total_addi_cost DOUBLE NOT NULL
);

CREATE TABLE total_costs (
  tcfarmer_id INT, 
  tccrop_code INT, 
  tcseed_code INT, 
  tcfertilizer_code INT, 
  tcpesticide_code INT, 
  tcherbicide_code INT, 
  qnty_seedused INT NOT NULL,
  qnty_fertilizerused INT,
  qnty_pesticideused INT,
  qnty_herbicideused INT,
  tcaddi_cost_code INT,  
  total_cost DOUBLE,
  
 PRIMARY KEY (tcfarmer_id, tccrop_code, tcseed_code, tcfertilizer_code, tcpesticide_code, tcherbicide_code),
 FOREIGN KEY (tcfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
 FOREIGN KEY (tccrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE,
 FOREIGN KEY (tcseed_code) REFERENCES seed_data (seed_code) ON DELETE CASCADE,
 FOREIGN KEY (tcfertilizer_code) REFERENCES fertilizer_data (fertilizer_code) ON DELETE CASCADE,
 FOREIGN KEY (tcpesticide_code) REFERENCES pesticide_data (pesticide_code) ON DELETE CASCADE,
 FOREIGN KEY (tcherbicide_code) REFERENCES herbicide_data (herbicide_code) ON DELETE CASCADE,
 
 FOREIGN KEY (tcaddi_cost_code) REFERENCES additional_costs (addi_cost_code) ON DELETE CASCADE
 );









