#!/usr/bin/env bash

html_dir=${1}
download=${2:-'no'}
prefix_url="https://upload.umin.ac.jp/cgi-open-bin/ctr_e/index.cgi"
suffix_url="?sort=03&isicdr=1&page="


function download_main_index(){
    wget  -q ${prefix_url}${suffix_url}"1" \
         -O ${html_dir}/index.html  || true
}

function download_index_page(){
    wget -q ${prefix_url}${suffix_url}${1} -O ${html_dir}/${1}.html  || true
}

if [[ ${download} == 'yes' ]]; then

    if [ -d ${html_dir} ]; then
        rm -rf ${html_dir}
    fi

    mkdir -p ${html_dir}/studies
    mkdir ${html_dir}/studies/json
    mkdir ${html_dir}/studies/analysis

    download_main_index

    cat ${html_dir}/index.html | pup 'table tr td a font[color="#3300FF"] json{}' | jq '.[].text' | while read f
    do
#            echo ${f}
             g=${f//\"/}
            download_index_page ${g}
    done
fi