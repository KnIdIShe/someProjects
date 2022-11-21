#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/21 13:49

#

from selenium import webdriver
from selenium.webdriver.chrome.service import Service

service = Service('phantomjs.exe')
# selenium 4.1.3 不支持
browser = webdriver.PhantomJS(service)

url = 'https://www.baidu.com'
browser.get(url)

browser.save_screenshot('baidu.png')
