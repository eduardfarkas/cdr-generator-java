insert into
    EXTENSIONS (id, created, changed, name, description)
values
    (10001, current_timestamp(), current_timestamp(), 'lte', 'for data cdrs'),
    (10002, current_timestamp(), current_timestamp(), 'sms', 'for sms cdrs'),
    (10003, current_timestamp(), current_timestamp(), 'gvoice', 'for voice cdrs'),
    (10004, current_timestamp(), current_timestamp(), 'mms', 'for mms cdrs');
