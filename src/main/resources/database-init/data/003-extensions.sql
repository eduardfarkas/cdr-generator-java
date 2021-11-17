insert into
    EXTENSIONS (id, created, changed, name, description)
values
    (1, current_timestamp(), current_timestamp(), 'lte', 'for data cdrs'),
    (2, current_timestamp(), current_timestamp(), 'sms', 'for sms cdrs'),
    (3, current_timestamp(), current_timestamp(), 'gvoice', 'for voice cdrs'),
    (4, current_timestamp(), current_timestamp(), 'mms', 'for mms cdrs');
