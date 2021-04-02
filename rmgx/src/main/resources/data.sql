insert into asset_category values (1, 'description of electronics','Electronics');

insert into asset_category values (2, 'description of furniture', 'Furniture');

INSERT INTO employee (`employee_id`, `designation`, `name`) VALUES ('1', 'Developer', 'Employee One');
INSERT INTO employee (`employee_id`, `designation`, `name`) VALUES ('2', 'HR', 'Employee Two');

INSERT INTO asset (`asset_id`, `condition_note`, `name`, `purchase_date`, `status`, `category_id`, `employee_employee_id`) VALUES ('1', 'Good', 'Table 1', '2017-09-09', 'Assigned', '1', '1');
INSERT INTO asset (`asset_id`, `condition_note`, `name`, `purchase_date`, `status`, `category_id`) VALUES ('2', 'Good', 'Chair', '2017-09-09', 'Available', '2');
INSERT INTO asset (`asset_id`, `condition_note`, `name`, `purchase_date`, `status`, `category_id`) VALUES ('3', 'Bad', 'Dell Laptop', '2017-09-09', 'Available', '1');
INSERT INTO asset (`asset_id`, `condition_note`, `name`, `purchase_date`, `status`, `category_id`) VALUES ('4', 'Excellent', 'HP Laptop', '2017-09-09', 'Available', '1');
INSERT INTO asset (`asset_id`, `condition_note`, `name`, `purchase_date`, `status`, `category_id`) VALUES ('5', 'Bad', 'Table 2', '2017-09-09', 'Available', '2');
INSERT INTO asset (`asset_id`, `condition_note`, `name`, `purchase_date`, `status`, `category_id`, `employee_employee_id`) VALUES ('6', 'Good', 'Lenovo Laptop', '2017-09-09', 'Assigned', '1', '1');