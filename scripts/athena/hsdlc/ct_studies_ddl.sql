CREATE EXTERNAL TABLE `ct_studies` (
    `participant_flow`
     struct<`recruitment_details`:string,
            `pre_assignment_details`:string,
            `group_list`:struct<`group`:array<struct<`title`:string,`description`:string,`group_id`:string>>>,
            `period_list`:struct<`period`:array<struct<`title`:string,
            `milestone_list`:struct<`milestone`:array<struct<`title`:string, `participants`:array<struct<`group_id`:string,`count`:string,`text_node_value`:string>>>>>,
            `group_id`:string>>>>,
    `baseline`
    struct<`population`:string,
            `group_list`:struct<`group`:array<struct<`title`:string,`description`:string,`group_id`:string>>>,
            `analyzed_list`:struct<`analyzed`:array<struct<`units`:string,`scope`:string,
            `count_list`:struct<`count`:array<struct<`group_id`:string,`value`:string,`text_node_value`:string>>>>>>,
            `measure_list`:struct<`measure`:array<struct<`title`:string,`description`:string,`population`:string,`units`:string,`param`:string,`dispersion`:string,`units_analyzed`:string,
            `analyzed_list`:struct<`analyzed`:array<struct<`units`:string,`scope`:string,
            `count_list`:struct<`count`:array<struct<`group_id`:string,`value`:string,`text_node_value`:string>>>>>>,
            `class_list`:struct<`class`:array<struct<`title`:string,
            `analyzed_list`:struct<`analyzed`:array<struct<`units`:string,`scope`:string,
            `count_list`:struct<`count`:array<struct<`group_id`:string,`value`:string,`text_node_value`:string>>>>>>,
            `category_list`:struct<`category`:array<struct<`title`:string,
             `measurement_list`:struct<`measurement`:array<struct<`group_id`:string,`value`:string,`spread`:string,`lower_limit`:string,`upper_limit`:string,`text_node_value`:string>>>>>>>>>>>>>,
     `outcome_list`
     struct<`outcome`:array<struct<`type`:string,`title`:string,`description`:string,`time_frame`:string,`safety_issue`:string,
                    `posting_date`:string,`population`:string,
            `group_list`:struct<`group`:array<struct<`title`:string,`description`:string,`group_id`:string>>>,
            `measure`:struct<`title`:string,`description`:string,`population`:string,`units`:string,`param`:string,`dispersion`:string,`units_analyzed`:string,
            `analyzed_list`:struct<`analyzed`:array<struct<`units`:string,`scope`:string,
            `count_list`:struct<`count`:array<struct<`group_id`:string,`value`:string,`text_node_value`:string>>>>>>,
            `class_list`:struct<`class`:array<struct<`title`:string,
            `analyzed_list`:struct<`analyzed`:array<struct<`units`:string,`scope`:string,
            `count_list`:struct<`count`:array<struct<`group_id`:string,`value`:string,`text_node_value`:string>>>>>>,
            `category_list`:struct<`category`:array<struct<`title`:string,
            `measurement_list`:struct<`measurement`:array<struct<`group_id`:string,`value`:string,`spread`:string,
                                                  `lower_limit`:string,`upper_limit`:string,`text_node_value`:string>>>>>>>>>>,
            `analysis_list`:struct<`analysis`:array<struct<`group_id_list`:struct<`group_id`:string>,`groups_desc`:string,`non_inferiority_type`:string,
            `non_inferiority_desc`:string,`p_value`:string,`p_value_desc`:string,`method`:string,
            `method_desc`:string,`param_type`:string,`param_value`:string,`dispersion_type`:string,`dispersion_value`:string,`ci_percent`:string,`ci_n_sides`:string,
            `ci_lower_limit`:string,`ci_upper_limit`:string,`ci_upper_limit_na_comment`:string,`estimate_desc`:string,`other_analysis_desc`:string>>>>>>,
     `reported_events`
     struct<`time_frame`:string,`desc`:string,
            `group_list`:struct<`group`:array<struct<`title`:string,`description`:string,`group_id`:string>>>,
            `serious_events`:struct<`frequency_threshold`:string,`default_vocab`:string,`default_assessment`:string,
            `category_list`:struct<`category`:array<struct<`title`:string,
            `event_list`:struct<`event`:array<struct<`sub_title`:struct<`vocab`:string,`text_node_value`:string>,
                    `assessment`:string,`description`:string,`counts`:array<struct<`group_id`:string,`subjects_affected`:string,
                                                                                    `subjects_at_risk`:string,`events`:string,`text_node_value`:string>>>>>>>>>,
            `other_events`:struct<`frequency_threshold`:string,`default_vocab`:string,`default_assessment`:string,
            `category_list`:struct<`category`:array<struct<`title`:string,`event_list`:struct<`event`:array<struct<`sub_title`:struct<`vocab`:string,`text_node_value`:string>,
            `assessment`:string,`description`:string,`counts`:array<struct<`group_id`:string,`subjects_affected`:string,`subjects_at_risk`:string,`events`:string,
            `text_node_value`:string>>>>>>>>>>,
     `certain_agreements`
      struct<`pi_employee`:string,`restrictive_agreement`:string>,
      `limitations_and_caveats`string,
             `point_of_contact`struct<`name_or_title`:string,`organization`:string,`phone`:string,`email`:string>,
      `patient_data`struct<`sharing_ipd`:string,`ipd_description`:string>,
      `study_docs`struct<`study_doc`:array<struct<`doc_id`:string,`doc_type`:string,`doc_url`:string,`doc_comment`:string>>>,
      `responsible_party`struct<`responsible_party_type`:string,`investigator_affiliation`:string,`investigator_full_name`:string,`invewastigator_title`:string>,
      `intervention`array<struct<`intervention_type`:string,`intervention_name`:string,`description`:string,`arm_group_label`:string,`other_name`:string>>,
      `eligibility`struct<`study_pop`:struct<`textblock`:string>,`sampling_method`:string,`criteria`:struct<`textblock`:string>,
                    `gender`:string,`gender_based`:string,`minimum_age`:string,`maximum_age`:string,`healthy_volunteers`:string>,
      `overall_official`array<struct<`first_name`:string,`middle_name`:string,`last_name`:string,`degrees`:string,`role`:string,`affiliation`:string>>,
      `overall_contact`struct<`first_name`:string,`middle_name`:string,`last_name`:string,`degrees`:string,`phone`:string,`phone_ext`:string,`email`:string>,
      `overall_contact_backup`struct<`first_name`:string,`middle_name`:string,`last_name`:string,`degrees`:string,`phone`:string,`phone_ext`:string,`email`:string>,
      `oversight_info`struct<`has_dmc`:string,`is_fda_regulated_drug`:string,`is_fda_regulated_device`:string,`is_unapproved_device`:string,`is_ppsd`:string,`is_us_export`:string>,
      `arm_group`struct<`arm_group_label`:string,`arm_group_type`:string,`description`:string>,
      `expanded_access_info`struct<`expanded_access_type_individual`:string,`expanded_access_type_intermediate`:string,`expanded_access_type_treatment`:string>,
      `study_design_info`struct<`allocation`:string,`intervention_model`:string,`intervention_model_description`:string,`primary_purpose`:string,`observational_model`:string,
                `time_perspective`:string,`masking`:string,`masking_description`:string>,
     `required_header`struct<`download_date`:string,`link_text`:string,`url`:string>,
     `id_info`struct<`org_study_id`:string,`secondary_id`:string,`nct_id`:string,`nct_alias`:string>,
     `brief_title` string,
     `acronym` string,
     `official_title` string,
     `sponsors`struct<`lead_sponsor`:struct<`agency`:string,`agency_class`:string>,`collaborator`:array<struct<`agency`:string,`agency_class`:string>>>,
     `source` string,
     `why_stopped` string,
     `target_duration` string,
     `overall_status` string,
     `last_known_status` string,
     `phase` string,
     `study_type` string,
     `has_expanded_access` string,
     `biospec_retention` string,
     `number_of_arms` string,
     `number_of_groups` string,
     `verification_date` string,
     `study_first_submitted` string,
     `study_first_submitted_qc` string,
     `results_first_submitted` string,
     `results_first_submitted_qc` string,
     `disposition_first_submitted` string,
     `disposition_first_submitted_qc` string,
     `last_update_submitted` string,
     `last_update_submitted_qc` string,
     `enrollment`struct<`type`:string,`text_node_value`:string>,
     `study_first_posted`struct<`type`:string,`text_node_value`:string>,
     `results_first_posted`struct<`type`:string,`text_node_value`:string>,
     `disposition_first_posted`struct<`type`:string,`text_node_value`:string>,
     `last_update_posted`struct<`type`:string,`text_node_value`:string>,
     `completion_date`struct<`type`:string,`text_node_value`:string>,
     `start_date`struct<`type`:string,`text_node_value`:string>,
     `primary_completion_date`struct<`type`:string,`text_node_value`:string>,
     `brief_summary`struct<`textblock`:string>,
     `detailed_description`struct<`textblock`:string>,
     `biospec_descr`struct<`textblock`:string>,
     `keyword` string,
     `condition` string,
     `primary_outcome`array<struct<`measure`:string,`time_frame`:string,`description`:string>>,
     `secondary_outcome`array<struct<`measure`:string,`time_frame`:string,`description`:string>>,
     `other_outcome`array<struct<`measure`:string,`time_frame`:string,`description`:string>>,
     `reference`array<struct<`citation`:string,`PMID`:string>>,
     `results_reference`array<struct<`citation`:string,`PMID`:string>>,
     `link`array<struct<`url`:string,`description`:string>>,
     `location`array<struct<`facility`:struct<`name`:string,`address`:struct<`city`:string,`state`:string,`zip`:string,`country`:string>>,
     `status`:string,
     `contact`:struct<`first_name`:string,`middle_name`:string,`last_name`:string,`degrees`:string,`phone`:string,`phone_ext`:string,`email`:string>,
     `contact_backup`:struct<`first_name`:string,`middle_name`:string,`last_name`:string,`degrees`:string,`phone`:string,`phone_ext`:string,`email`:string>,
     `investigator`:array<struct<`first_name`:string,`middle_name`:string,`last_name`:string,`degrees`:string,`role`:string,`affiliation`:string>>>>,
     `location_countries` string,
     `removed_countries` string,
     `condition_browse` string,
     `intervention_browse` string)
     PARTITIONED BY (
      p_id string
      )
     ROW FORMAT SERDE 'org.openx.data.jsonserde.JsonSerDe'
     LOCATION 's3://hsdlc-results/ct-adapter/json'
     TBLPROPERTIES (
     'ignore.malformed.json'= 'true'
     );


MSCK REPAIR TABLE ct_studies;
