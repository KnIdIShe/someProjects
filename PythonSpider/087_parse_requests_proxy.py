#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/21 13:49

#

import json
import requests

url = 'http://www.baidu.com/s?'
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36'
}
data = {
    'wd': 'ip'
}
proxies = {
    'http': '103.37.141.69:80'
}

resp = requests.get(url, data, headers=headers, proxies=proxies)
content = resp.text

with open('proxy.html', 'w', encoding='utf-8') as f:
    f.write(content)
