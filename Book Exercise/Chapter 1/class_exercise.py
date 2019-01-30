import datatime

class PersonTypeError(TypeError):
    pass

class PersonValueError(object):
    pass

class Person(object):
    _num = 0
    def __init__(self, name, sex, birthday, id):
        if not (isinstance(name, str) and sex in ("M", "F")):
            raise PersonValueError(name, sex)
    try:
        birth = datatime.date(*birthday)
    except:
        raise PersonValueError("Wrong Date:", birthday)
    self._name = name
    self._sex  = sex
    self._birthday = birthday
    self._id   = id
    Person._num += 1
