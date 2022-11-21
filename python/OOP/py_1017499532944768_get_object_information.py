#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 获取对象信息

# import types
#
#
# def fn():
#     pass
#
#
# print(type(fn) == types.FunctionType)
# print(type(abs) == types.BuiltinFunctionType)
# print(type(lambda x: x) == types.LambdaType)
# print(type((x for x in range(10))) == types.GeneratorType)


# print(isinstance(123, int))

# list or tuple
# print(isinstance([1, 2, 3], (list, tuple)))


# class MyDog(object):
#     def __len__(self):
#         return 100
#
#
# dog = MyDog()
# print(len(dog))


# class MyObject(object):
#     def __init__(self):
#         self.x = 9
#
#     def power(self):
#         return self.x * self.x


# class Student(object):
#     name = 'Student'
#
#     def __init__(self, name):
#         self.name = name


# s = Student('tom')
# s.score = 90
#
# print(s.name)
# print(Student.name)
#
# s.name = 'jerry'
# print(s.name)
# print(Student.name)
#
# del s.name
# print(s.name)


# test 1
# 为了统计学生人数，可以给Student类增加一个类属性，每创建一个实例，该属性自动增加：
class Student(object):
    count = 0

    def __init__(self, name):
        self.name = name
        Student.count += 1


# 测试:
if Student.count != 0:
    print('测试失败!')
else:
    bart = Student('Bart')
    if Student.count != 1:
        print('测试失败!')
    else:
        lisa = Student('Bart')
        if Student.count != 2:
            print('测试失败!')
        else:
            print('Students:', Student.count)
            print('测试通过!')
