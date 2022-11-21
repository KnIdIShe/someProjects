#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 使用__slots__

class Student(object):
    __slots__ = ('name', 'age')


s = Student()
s.name = 'tom'

print(s.name)

s.score = 90

# def set_age(self, age):
#     self.age = age
#
#
# from types import MethodType
#
# s.set_age = MethodType(set_age, s)
# s.set_age(25)
# print(s.age)
#
# s2 = Student()
#
#
# # s2.set_age(23)
#
# def set_score(self, score):
#     self.score = score
#
#
# Student.set_score = set_score
#
# s.set_score(100)
# s2.set_score(67)
#
# print(s.score)
# print(s2.score)
