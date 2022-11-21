#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/14 10:47

# post 请求百度翻译详细翻译

import urllib.request
import urllib.parse
import json

url = 'https://fanyi.baidu.com/v2transapi?from=en&to=zh'
data = {
    'from': 'en',
    'to': 'zh',
    'query': 'spider',
    'simple_means_flag': '3',
    'sign': '63766.268839',
    'token': '5864ffef68fa04991f060e684b7f1a89',
    'domain': 'common'
}
data = urllib.parse.urlencode(data).encode('utf-8')

headers = {
    # 'Accept': '*/*',
    # 'Accept-Encoding': 'gzip, deflate, br',
    # 'Accept-Language': 'zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7',
    # 'Connection': 'keep-alive',
    # 'Content-Length': '117',
    # 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
    'Cookie': 'REALTIME_TRANS_SWITCH=1; FANYI_WORD_SWITCH=1; SOUND_SPD_SWITCH=1; SOUND_PREFER_SWITCH=1; HISTORY_SWITCH=1; APPGUIDE_10_0_2=1; BIDUPSID=4B48ABC5939AC9B9591BB7739F5A354F; PSTM=1640945162; BAIDUID=4B48ABC5939AC9B93B26C11F384A6E6C:FG=1; BAIDUID_BFESS=4B48ABC5939AC9B93B26C11F384A6E6C:FG=1; H_WISE_SIDS=107318_110085_127969_131861_179350_184716_188748_189755_191068_191256_191371_194085_194511_194529_194604_195329_195343_195467_195756_196050_196425_196514_197242_197711_197955_198123_198259_198418_199022_199082_199466_199489_200150_200349_200744_200959_200960_200993_201054_201178_201233_201360_201550_201576_201600_201702_201979_202477_202821_202906_202923_203196_203249_203309_203360_203545_203577_203605_203995_204031_204113_204158_204200_204431_204532_204859_204915_204941_204955_204976_205009_205218_205219_205240_205379_205485; BDUSS=JFOHpZVThWfjFNNVhYYjZxa3Rma2FDblVIZGhFSW85YzRMeHZrMGQ2bmszR3hpSUFBQUFBJCQAAAAAAAAAAAEAAAB1wssvztK63MOma2sAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAORPRWLkT0Vic0; BDUSS_BFESS=JFOHpZVThWfjFNNVhYYjZxa3Rma2FDblVIZGhFSW85YzRMeHZrMGQ2bmszR3hpSUFBQUFBJCQAAAAAAAAAAAEAAAB1wssvztK63MOma2sAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAORPRWLkT0Vic0; MCITY=-364%3A289%3A; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; av1_switch_v3=0; RT="z=1&dm=baidu.com&si=32k0tq12zzs&ss=l1xi6p2s&sl=4&tt=9ef&bcn=https%3A%2F%2Ffclog.baidu.com%2Flog%2Fweirwood%3Ftype%3Dperf&ld=e19s&ul=llqf&hd=llrk"; DOUBLE_LANG_SWITCH=0; BDRCVFR[S4-dAuiWMmn]=I67x6TjHwwYf0; delPer=0; PSINO=5; BDRCVFR[feWj1Vr5u3D]=I67x6TjHwwYf0; H_PS_PSSID=35838_36182_31660_36165_34584_36120_36193_36074_36125_36226_26350_35869_36094_36061; BA_HECTOR=agal818k2l84a58hol1h5f1p60r; Hm_lvt_64ecd82404c51e03dc91cb9e8c025574=1647659945,1649827772,1649905955; Hm_lpvt_64ecd82404c51e03dc91cb9e8c025574=1649905955; ab_sr=1.0.1_NTBhMWMwNTI0NTY0NWNiMDA1ZWZkZjY3NTI0NjVkMWU4YTZhZTYwYWNhYmQ4ODM3MjVlYjVlYTcxOGMwZGIyNDRkMjFiNmEyMmNlMDAzMzhlYWYxMGM0MDhhOTYxMTE1ZWJkYTM5OWNhMzIyYjljZmFkZTViMjI0NjMzZWRlOWU1OWY1ZmEyMzBmZWYwNWRlNTIzYTkzOTU5NzUwNzU3YWVkMzZiMmQ1Y2E1OGUyNmYwNzI4MTg1MDMyYWZhYTYx',
    # 'DNT': '1',
    # 'Host': 'fanyi.baidu.com',
    # 'Origin': 'https://fanyi.baidu.com',
    # 'Referer': 'https://fanyi.baidu.com/',
    # 'sec-ch-ua': '" Not A;Brand";v="99", "Chromium";v="99", "Google Chrome";v="99"',
    # 'sec-ch-ua-mobile': '?0',
    # 'sec-ch-ua-platform': '"Windows"',
    # 'Sec-Fetch-Dest': 'empty',
    # 'Sec-Fetch-Mode': 'cors',
    # 'Sec-Fetch-Site': 'same-origin',
    # 'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36',
    # 'X-Requested-With': 'XMLHttpRequest',
}

req = urllib.request.Request(url=url, data=data, headers=headers)
content = urllib.request.urlopen(req).read().decode('utf-8')

# str --> json obj
obj = json.loads(content)
print(obj)
