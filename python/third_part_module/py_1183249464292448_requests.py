#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# requests

import requests

# url = 'https://www.douban.com/'
# headers = {
#     'User-Agent': 'Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36'}

# r = requests.get(url, headers=headers)
# r = requests.get('https://v1.jinrishici.com/shuqing/daowang')
# print(r.status_code)
# print(r.text)

# r = requests.get('https://www.douban.com/search', headers=headers, params={'q': 'python', 'cat': '1001'})
# print(r.url)
# print(r.encoding)
# print(r.content)

# r = requests.get('https://v1.jinrishici.com/shuqing/daowang')
# print(r.json())

# r = requests.get('https://www.douban.com/',
#                  headers={'User-Agent': 'Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit'})
# print(r.text)

# r = requests.post('https://accounts.douban.com/login',
#                   data={'form_email': 'abc@example.com', 'form_password': '123456'})

# post json
# params = {'key': 'value'}
# r = requests.post(url, json=params)

# 上传文件
# upload_files = {'files': open('report.xls', 'rb')}
# r = requests.post(url, files=upload_files)

# r = requests.get('https://v1.jinrishici.com/shuqing/daowang')
# print(r.headers)

# r.cookies['ts']
#
# cs = {'token': '12345', 'status': 'working'}
# r = requests.get('url', cookies=cs, timeout=2.5)
