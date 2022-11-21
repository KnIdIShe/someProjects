#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/21 13:49

#

import json
import requests

url = 'https://fanyi.baidu.com/sug'
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36'
}
data = {
    'kw': 'eye'
}

resp = requests.post(url, data, headers=headers)
content = resp.text
obj = json.loads(content, encoding='utf_8')
print(obj)
