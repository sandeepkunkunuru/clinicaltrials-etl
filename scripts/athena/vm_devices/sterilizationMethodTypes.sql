CREATE EXTERNAL TABLE `fda_sterilization_method_types`(
 `PrimaryDI` string,
 `sterilizationMethod` string
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '|'
ESCAPED BY '\\'
LINES TERMINATED BY '\n'
LOCATION 's3://hsdlc-results/healthdevicesdata.org/fda/sterilizationMethodTypes/'
TBLPROPERTIES ('skip.header.line.count'='1')
;