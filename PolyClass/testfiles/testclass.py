class Dog:
    """A Test Class all about dogs"""
    legs = 4
    def bark(self):
        return "Woof!"
    def getNumLegs(self):
        return self.legs

d = Dog()
print(d.bark())
print(d.getNumLegs())
