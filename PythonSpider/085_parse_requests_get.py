#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/21 13:49

#

import requests

url = 'https://www.baidu.com/s?'
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36'
}
data = {
    'wd': '好雨知时节'
}

resp = requests.get(url, params=data, headers=headers)

content = resp.text
print(content)
