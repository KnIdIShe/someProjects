#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 使用模块

""" a test module """

__author__ = 'amihso'

import sys


def test():
    args = sys.argv
    if len(args) == 1:
        print('hello, world')
    elif len(args) == 2:
        print('hello, %s!' % args[1])
    else:
        print('too many arguments!')


def _private_1(name):
    return 'Hello, %s' % name


def _private_2(name):
    return 'Hi, %s' % name


def greeting(name):
    if (len(name)) > 3:
        return _private_1(name)
    else:
        return _private_2(name)


if __name__ == '__main__':
    # print(__doc__)
    # test()
    print(greeting('tom'))
    print(greeting('tom J. Trump'))
