insert into
    cdrs (id, data_type, operator_type, group_id, extension_id, is_used, name, value, description, charging_class, charging_code, created, changed)
values
    ( 10001, 'voice', 'postpaid', 10001, 10001, true,  'cdr1',  'value1',  'desc1', '01', '001', current_timestamp(), current_timestamp()),
    ( 10002, 'voice', 'postpaid', 10001, 10001, true,  'cdr2',  'value2',  'desc2', '01', '001', current_timestamp(), current_timestamp()),
    ( 10003, 'voice', 'postpaid', 10001, 10001, true,  'cdr3',  'value3',  'desc3', '01', '001', current_timestamp(), current_timestamp()),
    ( 10004, 'voice', 'postpaid', 10001, 10001, true,  'cdr4',  'value4',  'desc4', '01', '001', current_timestamp(), current_timestamp()),
    ( 10005, 'voice', 'postpaid', 10001, 10001, true,  'cdr5',  'value5',  'desc5', '01', '001', current_timestamp(), current_timestamp()),
    ( 10006, 'sms',   'postpaid', 10001, 10001, true,  'cdr6',  'value6',  'desc6', '02', '001', current_timestamp(), current_timestamp()),
    ( 10007, 'sms',   'postpaid', 10001, 10001, true,  'cdr7',  'value7',  'desc7', '02', '001', current_timestamp(), current_timestamp()),
    ( 10008, 'sms',   'prepaid',  10002, 10002, true,  'cdr8',  'value8',  'desc8', '02', '001', current_timestamp(), current_timestamp()),
    ( 10009, 'sms',   'prepaid',  10002, 10002, true,  'cdr9',  'value9',  'desc9', '02', '001', current_timestamp(), current_timestamp()),
    ( 10010, 'mms',   'prepaid',  10002, 10002, true, 'cdr10', 'value10', 'desc10', '02', '001', current_timestamp(), current_timestamp()),
    ( 10011, 'mms',   'prepaid',  10002, 10002, true, 'cdr11', 'value11', 'desc11', '03', '001', current_timestamp(), current_timestamp()),
    ( 10012, 'mms',   'prepaid',  10002, 10002, true, 'cdr12', 'value12', 'desc12', '03', '001', current_timestamp(), current_timestamp()),
    ( 10013, 'mms',   'prepaid',  10002, 10002, true, 'cdr13', 'value13', 'desc13', '03', '001', current_timestamp(), current_timestamp()),
    ( 10014, 'mms',   'prepaid',  10002, 10002, true, 'cdr14', 'value14', 'desc14', '03', '001', current_timestamp(), current_timestamp()),
    ( 10015, 'mms',   'm2m',      10003, 10003, true, 'cdr15', 'value15', 'desc15', '03', '001', current_timestamp(), current_timestamp()),
    ( 10016, 'data',  'm2m',      10003, 10003, true, 'cdr16', 'value16', 'desc16', '04', '001', current_timestamp(), current_timestamp()),
    ( 10017, 'data',  'm2m',      10003, 10003, true, 'cdr17', 'value17', 'desc17', '04', '001', current_timestamp(), current_timestamp()),
    ( 10018, 'data',  'm2m',      10003, 10003, true, 'cdr18', 'value18', 'desc18', '04', '001', current_timestamp(), current_timestamp()),
    ( 10019, 'data',  'm2m',      10003, 10003, true, 'cdr19', 'value19', 'desc19', '04', '001', current_timestamp(), current_timestamp()),
    ( 10020, 'data',  'm2m',      10003, 10003, true, 'cdr20', 'value20', 'desc20', '04', '001', current_timestamp(), current_timestamp());

