#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/17 20:35

# 解析淘票票json数据

import json
import jsonpath
import urllib.request
import re

url = 'https://dianying.taobao.com/cityAction.json?activityId&_ksTS=1650201270708_97&jsoncallback=jsonp98&action=cityAction&n_s=new&event_submit_doGetAllRegion=true'
headers = {
    'accept': 'text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01',
    'accept-language': 'zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7',
    'cookie': 't=a28f3341756c95aa8f2e315d0ff3d91d; thw=cn; tracknick=jjjjkkkkzzzz; enc=XR5IROawtogQeWfTQBvREQAmJUFJ%2B8MFEci6lE%2BX0zy26tsVOFuvlobBmaOvUL5y%2Bk%2FjgfMpTJ1AT6JQO9oE3A%3D%3D; cna=ddrNGnK7+WsCAXJSlbhPFASO; lgc=jjjjkkkkzzzz; sgcookie=E100nQVOF6PjlCvR2GXYKoPYcc8gJu7bVDYQiNOZg09mXdr9MHqfZ6%2FXprjvsh5P84hkOzopE0xOvhGLnww%2FFRqQS0U4FP8gIZbst6JDgtGMkufYnu0XsF1I75XxDg8HRj%2Bw; uc3=vt3=F8dCvChyvbJ4P1gURAM%3D&lg2=WqG3DMC9VAQiUQ%3D%3D&nk2=CdmvQiSFkd%2FOQClU&id2=UoH8Wsg9GuQHNw%3D%3D; uc4=nk4=0%40C%2BY%2FqwLxqizdnlyHwQrefpqeva65B8U%3D&id4=0%40UOnjmkVc1Ne2O7rYGr9Hrc8YQj4o; _cc_=VT5L2FSpdA%3D%3D; cookie2=1c97ac1119c23fbdfbfa8c9d8675579a; v=0; _tb_token_=33033b7150b17; xlly_s=1; l=eBIlwYxegvytBFrWBO5Cnurza77TXIRb81PzaNbMiInca6ThTF1MROC3pWuM7dtjgtfXiety52gX3ReHzi4p_giMW_N-1NKmdxJ6-; tfstk=cpufBOvK-tXXJK-NujOy7ZCILzUGZ41bwMeSGL1nqhPescGfifQUdS3aUtza671..; isg=BKamDhx0-G3-ja9shbJWIypr9xwoh-pBOA8AZJBPaUmkE0ct-BKaUcntay-fvOJZ',
    'dnt': '1',
    'referer': 'https://dianying.taobao.com/',
    'sec-ch-ua': '" Not A;Brand";v="99", "Chromium";v="100", "Google Chrome";v="100"',
    'sec-ch-ua-mobile': '?0',
    'sec-ch-ua-platform': '"Windows"',
    'sec-fetch-dest': 'empty',
    'sec-fetch-mode': 'cors',
    'sec-fetch-site': 'same-origin',
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.88 Safari/537.36',
    'x-requested-with': 'XMLHttpRequest',
}

req = urllib.request.Request(url=url, headers=headers)
resp = urllib.request.urlopen(req)
content = resp.read().decode('utf-8')

# content = re.split(r'[()]', content)[1]
content = content.split('(')[1].split(')')[0]

with open('074_parse_jsonpath_dianying_taobao.json', 'w', encoding='utf-8') as f:
    f.write(content)

obj = json.load(open('074_parse_jsonpath_dianying_taobao.json', 'r', encoding='utf-8'))
cities = jsonpath.jsonpath(obj, '$..regionName')
print(cities)
