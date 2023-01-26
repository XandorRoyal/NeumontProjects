class Monkey:
    Name = ""
    Items = []
    secondNum = 0
    t = ""
    Test = 0
    true = None
    false = None
    transfer = 0
    def __init__(self, name, startingItems, divisible, ifTrue, ifFalse, operation) -> None:
        self.Name = name
        self.Items = startingItems
        self.Test = int(divisible)
        self.secondNum = operation[2]
        self.t = operation[1]
        self.true = ifTrue
        self.false = ifFalse

    def shiftItems(self, monkeyList):
        newList = []
        if self.t == '+':
            newList = list(map(lambda x: int(x)+int(self.secondNum) ,self.Items))
        elif self.t == '*':
            if self.secondNum == 'old':
                newList = list(map(lambda x: int(x)*int(x) ,self.Items))
            else:
                newList = list(map(lambda x: int(x)*int(self.secondNum) ,self.Items))
        self.transfer += len(newList)
        newList = list(map(lambda x: x % 9699690,newList))
        newListTrue = list(filter(lambda x: int(x) % int(self.Test) == 0, newList))
        newListFalse = list(filter(lambda x: int(x) % int(self.Test) != 0, newList))
        monkeyList[int(self.true)].Items.extend(newListTrue)
        monkeyList[int(self.false)].Items.extend(newListFalse)
        self.Items = []



inp = """Monkey 0:
  Starting items: 52, 78, 79, 63, 51, 94
  Operation: new = old * 13
  Test: divisible by 5
    If true: throw to monkey 1
    If false: throw to monkey 6

Monkey 1:
  Starting items: 77, 94, 70, 83, 53
  Operation: new = old + 3
  Test: divisible by 7
    If true: throw to monkey 5
    If false: throw to monkey 3

Monkey 2:
  Starting items: 98, 50, 76
  Operation: new = old * old
  Test: divisible by 13
    If true: throw to monkey 0
    If false: throw to monkey 6

Monkey 3:
  Starting items: 92, 91, 61, 75, 99, 63, 84, 69
  Operation: new = old + 5
  Test: divisible by 11
    If true: throw to monkey 5
    If false: throw to monkey 7

Monkey 4:
  Starting items: 51, 53, 83, 52
  Operation: new = old + 7
  Test: divisible by 3
    If true: throw to monkey 2
    If false: throw to monkey 0

Monkey 5:
  Starting items: 76, 76
  Operation: new = old + 4
  Test: divisible by 2
    If true: throw to monkey 4
    If false: throw to monkey 7

Monkey 6:
  Starting items: 75, 59, 93, 69, 76, 96, 65
  Operation: new = old * 19
  Test: divisible by 17
    If true: throw to monkey 1
    If false: throw to monkey 3

Monkey 7:
  Starting items: 89
  Operation: new = old + 2
  Test: divisible by 19
    If true: throw to monkey 2
    If false: throw to monkey 4"""

inp = inp.split("\n\n")
monkeys = []
for monkey in inp:
    monkeyBreak = monkey.split('\n')
    name = monkeyBreak[0].split(' ')[1]
    startingItems = monkeyBreak[1].split(':')[1].replace(' ','').split(',')
    operation = monkeyBreak[2].split('= ')[1].split(' ')
    test = monkeyBreak[3].split('by ')[1]
    isTrue = monkeyBreak[4].split('monkey ')[1]
    isFalse = monkeyBreak[5].split('monkey ')[1]

    newMonkey = Monkey(name, startingItems, int(test), isTrue, isFalse, operation)
    monkeys.append(newMonkey)

for i in range(10000):
    for monkey in monkeys:
        monkey.shiftItems(monkeys)

times = []
for monkey in monkeys:
    print(monkey.transfer, monkey.Items)
    times.append(monkey.transfer)

monkeyBiz = max(times) * max([x for x in times if x is not max(times)])
print(monkeyBiz)