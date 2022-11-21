#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 错误处理

# try:
#     print('try...')
#     # r = 10 / int('a')
#     # r = 10 / 0
#     r = 10 / 2
#     print('result:', r)
# except ValueError as e:
#     print('except:', e)
# except ZeroDivisionError as e:
#     print('except:', e)
# else:
#     print('no error')
# finally:
#     print('finally...')
# print('end')

import logging


def foo(s):
    return 10 / int(s)


def bar(s):
    return foo(s) * 2


def main():
    try:
        bar(0)
    except Exception as e:
        logging.exception(e)


main()
print('end')
