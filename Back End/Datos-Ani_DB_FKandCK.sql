ALTER TABLE plotofland
ADD FOREIGN KEY (plfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE SET NULL,
ADD FOREIGN KEY (plfertilizer_code) REFERENCES fertilizer_data (fertilizer_code) ON DELETE SET NULL,
ADD FOREIGN KEY (plpesticide_code) REFERENCES pesticide_data (pesticide_code) ON DELETE SET NULL,
ADD FOREIGN KEY (plherbicide_code) REFERENCES herbicide_data (herbicide_code) ON DELETE SET NULL,
ADD FOREIGN KEY (plseed_code) REFERENCES seed_data (seed_code) ON DELETE SET NULL;

ALTER TABLE crops_data
ADD FOREIGN KEY (cpfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE SET NULL,
ADD FOREIGN KEY (cpbotanicfam_code) REFERENCES botanicfam (botanicfam_code) ON DELETE SET NULL,
ADD FOREIGN KEY (cpplot_land_code) REFERENCES plotofland (plot_land_code) ON DELETE SET NULL;

ALTER TABLE crop_sales
ADD PRIMARY KEY (salesfarmer_id, salescrop_code),
ADD FOREIGN KEY (salesfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
ADD FOREIGN KEY (salescrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE;

ALTER TABLE crop_profit
ADD PRIMARY KEY (profitfarmer_id, profitcrop_code),
ADD FOREIGN KEY (profitfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
ADD FOREIGN KEY (profitcrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE;

ALTER TABLE total_costs
ADD PRIMARY KEY (tcfarmer_id, tccrop_code, tcseed_code, tcfertilizer_code, tcpesticide_code, tcherbicide_code),
ADD FOREIGN KEY (tcfarmer_id) REFERENCES farmer_info (farmer_id) ON DELETE CASCADE,
ADD FOREIGN KEY (tccrop_code) REFERENCES crops_data (crop_code) ON DELETE CASCADE,
ADD FOREIGN KEY (tcseed_code) REFERENCES seed_data (seed_code) ON DELETE CASCADE,
ADD FOREIGN KEY (tcfertilizer_code) REFERENCES fertilizer_data (fertilizer_code) ON DELETE CASCADE,
ADD FOREIGN KEY (tcpesticide_code) REFERENCES pesticide_data (pesticide_code) ON DELETE CASCADE,
ADD FOREIGN KEY (tcherbicide_code) REFERENCES herbicide_data (herbicide_code) ON DELETE CASCADE,
 
ADD FOREIGN KEY (tcaddi_cost_code) REFERENCES additional_costs (addi_cost_code) ON DELETE CASCADE;


