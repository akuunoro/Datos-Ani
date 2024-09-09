CREATE TABLE farmer_info (
  farmer_id INT PRIMARY KEY AUTO_INCREMENT,
  frmr_last_name VARCHAR(25) NOT NULL,
  frmr_middle_name VARCHAR(25) NOT NULL,
  frmr_first_name VARCHAR(25) NOT NULL,
  frmr_address VARCHAR (50) NOT NULL,
  frmr_gender VARCHAR (10) NOT NULL,
  frmr_mobilenum VARCHAR (11) NOT NULL,
  frmr_birthdate VARCHAR (20) NOT NULL,
  frmr_emailaddress VARCHAR(50) NOT NULL,
  frmr_password VARCHAR (20) NOT NULL
);

CREATE TABLE botanicfam (
  botanicfam_code INT PRIMARY KEY AUTO_INCREMENT,
  botanical_family VARCHAR(60),
  botanicfam_crops VARCHAR(60)
);

CREATE TABLE fertilizer_data (
  fertilizer_code INT PRIMARY KEY AUTO_INCREMENT,
  ffarmer_id INT, /*FK -*/
  fcrop_code INT, /*FK --*/
  name_fertilizer VARCHAR(50),
  price_fertilizer VARCHAR(25),
  
  FOREIGN KEY (ffarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE
);

CREATE TABLE herbicide_data (
  herbicide_code INT PRIMARY KEY AUTO_INCREMENT,
  hfarmer_id INT, /*FK -*/
  hcrop_code INT, /*FK --*/
  name_herbicide VARCHAR(50),
  price_herbicide VARCHAR (25),
  
  FOREIGN KEY (hfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE
);

CREATE TABLE pesticide_data (
  pesticide_code INT PRIMARY KEY AUTO_INCREMENT,
  pfarmer_id INT, /*FK -*/
  pcrop_code INT, /*FK --*/
  name_pesticide VARCHAR(50),
  price_pesticide VARCHAR (25),
  
  FOREIGN KEY (pfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE
);

CREATE TABLE seed_data (
  seed_code INT PRIMARY KEY AUTO_INCREMENT,
  sfarmer_id INT, /*FK -*/
  scrop_code INT, /*FK --*/
  name_seed VARCHAR (50),
  price_seed VARCHAR (25),
  
  FOREIGN KEY (sfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE
);

CREATE TABLE plotofland (
  plot_land_code INT PRIMARY KEY AUTO_INCREMENT,
  plfarmer_id INT, /*FK -*/
  plcrop_code INT, /*FK --*/
  date_planted VARCHAR (25),
  date_harvest VARCHAR (25),
  plfertilizer_code INT, /*FK -*/
  plpesticide_code INT, /*FK -*/
  plherbicide_code INT, /*FK -*/
  plseed_code INT, /*FK -*/
  
  FOREIGN KEY (plfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
  FOREIGN KEY (plfertilizer_code) REFERENCES fertilizer_data (fertilizer_code) ON DELETE SET NULL,
  FOREIGN KEY (plpesticide_code) REFERENCES pesticide_data (pesticide_code) ON DELETE SET NULL,
  FOREIGN KEY (plherbicide_code) REFERENCES herbicide_data (herbicide_code) ON DELETE SET NULL,
  FOREIGN KEY (plseed_code) REFERENCES seed_data (seed_code) ON DELETE CASCADE
);


CREATE TABLE crops_data (
  crop_code INT PRIMARY KEY AUTO_INCREMENT,
  uk_cropidentifier VARCHAR(75),
  vegetable_name VARCHAR(60) NOT NULL,
  cpfarmer_id INT, /*FK -*/
  cpbotanicfam_code INT, /*FK -*/
  cpplot_land_code INT, /*FK -*/
  cpseason VARCHAR (5),
  crop_rotation VARCHAR (3) NOT NULL,
  yielded_qnty VARCHAR (25) NOT NULL,
  crop_price VARCHAR (25) NOT NULL,
  
  FOREIGN KEY (cpfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
  FOREIGN KEY (cpbotanicfam_code) REFERENCES botanicfam (botanicfam_code) ON DELETE CASCADE,
  FOREIGN KEY (cpplot_land_code) REFERENCES plotofland (plot_land_code) ON DELETE CASCADE
);


ALTER TABLE fertilizer_data
ADD FOREIGN KEY (fcrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE;

ALTER TABLE herbicide_data
ADD FOREIGN KEY (hcrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE;

ALTER TABLE pesticide_data
ADD FOREIGN KEY (pcrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE;

ALTER TABLE seed_data 
ADD FOREIGN KEY (scrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE;

ALTER TABLE plotofland
ADD FOREIGN KEY (plcrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE;


CREATE TABLE crop_sales (
  sales_code INT PRIMARY KEY AUTO_INCREMENT,
  salesfarmer_id INT, /*FK -*/
  salescrop_code INT, /*FK -*/
  sold_qnty VARCHAR (25),
  total_sales VARCHAR (25),
  
  FOREIGN KEY (salesfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
  FOREIGN KEY (salescrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE
); 

CREATE TABLE crop_profit ( 
  profit_code INT PRIMARY KEY AUTO_INCREMENT,
  profitfarmer_id INT, /*FK -*/
  profitcrop_code INT, /*FK -*/
  profitcrop_sales INT, /*FK -*/
  profittotal_costs INT, /*FK -*/
  total_profit VARCHAR (25),
  
  FOREIGN KEY (profitfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
  FOREIGN KEY (profitcrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE,
  FOREIGN KEY (profitcrop_sales) REFERENCES crop_sales (sales_code) ON DELETE CASCADE,
  FOREIGN KEY (profittotal_costs) REFERENCES crops_data (crop_code) ON DELETE CASCADE
);

CREATE TABLE additional_costs (
  addi_cost_code INT PRIMARY KEY AUTO_INCREMENT,
  addi_farmerid INT, /*FK -*/
  addi_crop_code INT, /*FK -*/
  total_addi_cost VARCHAR (25),
  
  FOREIGN KEY (addi_farmerid) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
  FOREIGN KEY (addi_crop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE
);

CREATE TABLE total_costs (
  costs_code INT PRIMARY KEY AUTO_INCREMENT,
  tcfarmer_id INT, /*FK -*/
  tccrop_code INT, /*FK -*/
  tcseed_code INT, /*FK -*/
  tcfertilizer_code INT, /*FK -*/
  tcpesticide_code INT, /*FK -*/
  tcherbicide_code INT, /*FK -*/
  qnty_seedused INT NOT NULL,
  qnty_fertilizerused INT, 
  qnty_pesticideused INT, 
  qnty_herbicideused INT, 
  tcaddi_cost_code INT, /*FK -*/
  total_cost VARCHAR(50),
  
 FOREIGN KEY (tcfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
 FOREIGN KEY (tccrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE,
 FOREIGN KEY (tcseed_code) REFERENCES seed_data (seed_code) ON DELETE CASCADE,
 FOREIGN KEY (tcfertilizer_code) REFERENCES fertilizer_data (fertilizer_code) ON DELETE CASCADE,
 FOREIGN KEY (tcpesticide_code) REFERENCES pesticide_data (pesticide_code) ON DELETE CASCADE,
 FOREIGN KEY (tcherbicide_code) REFERENCES herbicide_data (herbicide_code) ON DELETE CASCADE,
 
 FOREIGN KEY (tcaddi_cost_code) REFERENCES additional_costs (addi_cost_code) ON DELETE CASCADE
 );


CREATE TABLE schedcrop_rotation(
	sched_cr_code INT PRIMARY KEY AUTO_INCREMENT,
    scrfarmer_id INT,
	scr_botanicfamcode INT,
    scr_cropname VARCHAR(45),
    scr_plantdate VARCHAR(25),
    scr_plantyear VARCHAR(10),
	
    FOREIGN KEY (scrfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
    FOREIGN KEY (scr_botanicfamcode) REFERENCES botanicfam (botanifam_code) ON DELETE CASCADE
);

CREATE TABLE schedcrop_harvest(
	sched_ch_code INT PRIMARY KEY AUTO_INCREMENT,
    schfarmer_id INT,
    sch_botanicfamcode INT,
    sch_cropname VARCHAR(45),
    sch_plantdate VARCHAR(25),
    sch_plantyear VARCHAR(10),
	
    FOREIGN KEY (schfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
    FOREIGN KEY (sch_botanicfamcode) REFERENCES botanicfam (botanifam_code) ON DELETE CASCADE
);



