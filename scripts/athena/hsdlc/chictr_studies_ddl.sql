CREATE EXTERNAL TABLE `chictr_studies`(
`Registration_number` string,
  `Date_of_Last_Refreshed_on` string,
  `Date_of_Registration` string,
  `Registration_Status` string,
  `Public_title` string,
  `English_Acronym` string,
  `Scientific_title` string,
  `Study_subject_ID` string,
  `The_registration_number_of_the_Partner_Registry_or_other_register` string,
  `Applicant` string,
  `Study_leader` string,
  `Applicant_telephone` string,
  `Study_leaders_telephone` string,
  `Applicant_Fax` string,
  `Study_leaders_fax` string,
  `Applicant_websitevoluntary_supply` string,
  `Study_leaders_websitevoluntary_supply` string,
  `Applicant_address` string,
  `Study_leaders_address` string,
  `Applicant_postcode` string,
  `Study_leaders_postcode` string,
  `Applicants_institution` string,
  `Approved_by_ethic_committee` string,
  `Approved_No._of_ethic_committee` string,
  `Approved_file_of_Ethical_Committee` string,
  `Name_of_the_ethic_committee` string,
  `Date_of_approved_by_ethic_committee` string,
  `Contact_Name_of_the_ethic_committee` string,
  `Contact_Address_of_the_ethic_committee` string,
  `Contact_phone_of_the_ethic_committee` string,
  `Contact_email_of_the_ethic_committee` string,
  `Primary_sponsor` string,
  `Primary_sponsors_address` string,
  `Secondary_sponsor` Array<Map<string,string>>,
  `Sources_of_funding` string,
  `Target_disease` string,
  `Target_disease_code` string,
  `Study_type` string,
  `Study_phase` string,
  `Objectives_of_Study` string,
  `Description_for_medicine_or_protocol_of_treatment_in_detail` string,
  `Study_design` string,
  `Exclusion_criteria` string,
  `Study_execute_time` string,
  `Interventions` struct<Interventions:string,
      `Group`:string,
      `Sample_size`:string,
      `Intervention`:string,
      `Intervention_code`:string>, 
  `Countries_of_recruitment_and_research_settings` struct<
      `Country`:string,
      `Province`:string,
      `City`:string,
      `Institution_hospital`:string,
      `Level_of_the_institution`:string>,
`Outcomes` struct<
    `Outcome`:string,
    `Type`:string,
    `Measure_time_point_of_outcome`:string,
    `Measure_method`:string>,
`Collecting_samples_from_participants` string,
`Recruiting_status` string,
`Gender` string,
`Randomization_Procedure_please_state_who_generates_the_random_number_sequence_and_by_what_method` string,
`Measure_method` string,
`Blinding` string,
`Calculated_Results_ater_the_Study_Completedupload_file` string,
`The_time_of_sharing_IPD` string,
`Measure_time_point_of_outcome` string,
`Data_collection_and_Management_A_standard_data_collection_and_management_system_include_a_CRF_and_an_electronic_data_capture` string,
`Data_Managemen_Committee` string,
`Name_of_Registration`string
        
  )
  ROW FORMAT SERDE 'org.openx.data.jsonserde.JsonSerDe'
  LOCATION 's3://hsdlc-results/chictr-adapter/json'
  TBLPROPERTIES (
  'ignore.malformed.json'= 'true'
  );
 