#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 面向对象编程

class Student(object):

    # def __init__(self, name, score):
    #     self.name = name
    #     self.score = score

    def __init__(self, name, score):
        self.__name = name
        self.__score = score

    def get_name(self):
        return self.__name

    def get_score(self):
        return self.__score

    def set_score(self, score):
        if 0 <= score <= 100:
            self.__score = score
        else:
            raise ValueError('bad score.')

    def print_score(self):
        print('%s: %s' % (self.__name, self.__score))

    def get_grade(self):
        if self.__score >= 90:
            return 'A'
        elif self.__score >= 60:
            return 'B'
        else:
            return 'C'


stu1 = Student('tom', 87)
stu2 = Student('jerry', 34)

# stu1.print_score()
# stu2.print_score()

# stu1.print_score()
print(stu1.get_name())
# print(stu1.get_grade())
# print(stu2.get_grade())
