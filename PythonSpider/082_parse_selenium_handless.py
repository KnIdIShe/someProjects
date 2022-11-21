#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/21 13:49

#

from selenium import webdriver
from selenium.webdriver.chrome.options import Options


def getBrowser():
    chrome_options = Options()
    chrome_options.add_argument('headless')
    chrome_options.add_argument('disable‐gpu')
    path = r'C:\Users\Cruz\AppData\Local\Google\Chrome\Application\chrome.exe'
    chrome_options.binary_location = path
    browser = webdriver.Chrome(options=chrome_options)
    return browser


url = 'https://www.baidu.com'
browser = getBrowser()
browser.get(url)

browser.save_screenshot('baidu.png')
