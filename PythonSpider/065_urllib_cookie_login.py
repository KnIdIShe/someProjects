#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/14 10:47

# cookie login

import urllib.request
import urllib.error

url = 'https://so.gushiwen.cn/user/collect.aspx'

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/99.0.4844.51 Safari/537.36',
    'cookie': 'login=flase; Hm_lvt_9007fab6814e892d3020a64454da5a55=1648475222,1648958878,1649930078; '
              'ASP.NET_SessionId=askoikq3xexmwy5q2tfolxy2; gsw2017user=2647244%7c45D3B5C730E662C442A59E605A157B9F; '
              'login=flase; gswZhanghao=rahratch%40foxmail.com; gswEmail=rahratch%40foxmail.com; '
              'wsEmail=rahratch%40foxmail.com; wxopenid=defoaltid; Hm_lpvt_9007fab6814e892d3020a64454da5a55=1649930244 '
}

req = urllib.request.Request(url=url, headers=headers)
resp = urllib.request.urlopen(req)
content = resp.read().decode('utf-8')
print(content)
