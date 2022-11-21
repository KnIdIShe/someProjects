def age():
    s = input('plz input ur age: ')
    # 参数类型检查
    if not isinstance(s, int):
        raise TypeError('bad operand type')

    age = int(s)
    if age >= 18:
        print('adult')
        # return 'adult'
    elif age >= 6:
        print('teenager')
        # return 'teenager'
    else:
        print('kid')
        # return 'kid'
