def main():
    f = None
    try:
        f = open('致橡树.txt', 'r', encoding='utf-8')
        print(f.read())
    except FileNotFoundError:
        print('无法打开指定的文件!')
    except LookupError:
        print('指定了未知的编码!')
    except UnicodeDecodeError:
        print('读取文件时解码错误!')
    finally:
        if f:
            f.close()


def main():
    try:
        with open('norm.txt', 'r', encoding='utf-8') as f:
            print(f.read())
    except FileNotFoundError:
        print('无法打开指定的文件!')
    except LookupError:
        print('指定了未知的编码!')
    except UnicodeDecodeError:
        print('读取文件时解码错误!')

if __name__ == '__main__':
    main()


# Json Parse
序列化（serialization）在计算机科学的数据处理中，是指将数据结构或对象状态转换为可以存储或传输的形式，这样在需要的时候能够恢复到原先的状态，
而且通过序列化的数据重新获取字节时，可以利用这些字节来产生原始对象的副本（拷贝）。
与这个过程相反的动作，即从一系列字节中提取数据结构的操作，就是反序列化（deserialization）

import json

def main():
    mydict = {
            'name': '骆昊',
            'age': 38,
            'qq': 957658,
            'friends': ['王大锤', '白元芳'],
            'cars': [
                {'brand': 'BYD', 'max_speed': 180},
                {'brand': 'Audi', 'max_speed': 280},
                {'brand': 'Benz', 'max_speed': 320}
            ]
        }
    try:
        with open('data.json', 'w', encoding = 'utf-8') as fs:
            json.dump(mydict, fs)
    except IOError as e:
        print(e)
    print('保存数据完成!')
