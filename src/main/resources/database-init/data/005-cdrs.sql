insert into
    cdrs (id, data_type_id, operator_id, group_id, extension_id, is_used, name, value, description, charging_class, charging_code, created, changed)
values
    ( 1, 1, 1, 1, 1, true,  'cdr1',  'value1',  'desc1', '01', '001', current_timestamp(), current_timestamp()),
    ( 2, 1, 1, 1, 1, true,  'cdr2',  'value2',  'desc2', '01', '001', current_timestamp(), current_timestamp()),
    ( 3, 1, 1, 1, 1, true,  'cdr3',  'value3',  'desc3', '01', '001', current_timestamp(), current_timestamp()),
    ( 4, 1, 1, 1, 1, true,  'cdr4',  'value4',  'desc4', '01', '001', current_timestamp(), current_timestamp()),
    ( 5, 1, 1, 1, 1, true,  'cdr5',  'value5',  'desc5', '01', '001', current_timestamp(), current_timestamp()),
    ( 6, 2, 1, 2, 2, true,  'cdr6',  'value6',  'desc6', '02', '001', current_timestamp(), current_timestamp()),
    ( 7, 2, 1, 2, 2, true,  'cdr7',  'value7',  'desc7', '02', '001', current_timestamp(), current_timestamp()),
    ( 8, 2, 2, 2, 2, true,  'cdr8',  'value8',  'desc8', '02', '001', current_timestamp(), current_timestamp()),
    ( 9, 2, 2, 2, 2, true,  'cdr9',  'value9',  'desc9', '02', '001', current_timestamp(), current_timestamp()),
    (10, 3, 2, 2, 2, true, 'cdr10', 'value10', 'desc10', '02', '001', current_timestamp(), current_timestamp()),
    (11, 3, 2, 3, 3, true, 'cdr11', 'value11', 'desc11', '03', '001', current_timestamp(), current_timestamp()),
    (12, 3, 2, 3, 3, true, 'cdr12', 'value12', 'desc12', '03', '001', current_timestamp(), current_timestamp()),
    (13, 3, 2, 3, 3, true, 'cdr13', 'value13', 'desc13', '03', '001', current_timestamp(), current_timestamp()),
    (14, 3, 2, 3, 3, true, 'cdr14', 'value14', 'desc14', '03', '001', current_timestamp(), current_timestamp()),
    (15, 3, 3, 3, 3, true, 'cdr15', 'value15', 'desc15', '03', '001', current_timestamp(), current_timestamp()),
    (16, 4, 3, 4, 4, true, 'cdr16', 'value16', 'desc16', '04', '001', current_timestamp(), current_timestamp()),
    (17, 4, 3, 4, 4, true, 'cdr17', 'value17', 'desc17', '04', '001', current_timestamp(), current_timestamp()),
    (18, 4, 3, 4, 4, true, 'cdr18', 'value18', 'desc18', '04', '001', current_timestamp(), current_timestamp()),
    (19, 4, 3, 4, 4, true, 'cdr19', 'value19', 'desc19', '04', '001', current_timestamp(), current_timestamp()),
    (20, 4, 3, 4, 4, true, 'cdr20', 'value20', 'desc20', '04', '001', current_timestamp(), current_timestamp());
