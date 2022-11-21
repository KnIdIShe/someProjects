#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 序列化

# import pickle
#
# d = dict(name='bob', age=12, score=88)
# b = pickle.dumps(d)
# print(b)

# f = open('dump.txt', 'wb')
# pickle.dump(d, f)
# f.close()

# import pickle
#
# with open('dump.txt', 'rb') as f:
#     d = pickle.load(f)
#
# print(d)


# import json

# d = dict(name='tom', age=12, score=88)
#
# b = json.dumps(d)
# print(b)

# json_str = '{"name": "tom", "age": 12, "score": 88}'
# d = json.loads(json_str)
# print(d)


import json


class Student(object):
    def __init__(self, name, age, score):
        self.name = name
        self.age = age
        self.score = score


def student2dict(std):
    return {
        'name': std.name,
        'age': std.age,
        'score': std.score
    }


def dict2student(d):
    return Student(d['name'], d['age'], d['score'])


# s = Student('tom', 12, 45)
# print(s.__dict__)
# print(json.dumps(s, default=student2dict))
# print(json.dumps(s, default=lambda obj: obj.__dict__))

json_str = '{"name": "tom", "age": 12, "score": 45}'
print(json.loads(json_str, object_hook=dict2student))
