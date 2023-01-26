import math
class CPUClock:
    instructions = []
    cycleRecord = []
    displayMap = [['.'],[],[],[],[],[],[]]
    signalStrength = 1
    cycle = 0
    pointer = 0
    def __init__(self, ins) -> None:
        self.instructions = ins
        self.cycleRecord = []
        self.cycle = 0
        self.signalStrength = 1
        self.pointer = 0

    def determineInstructions(self,command):
        if command[0] == "noop": return 1, None
        elif command[0] == 'addx': return 2, int(command[1])

    def getScore(self):
        total = 0
        if self.cycle >= 20:
            iterations = []
            totalIterations = math.floor((self.cycle-20)/40)
            for n in range(0,totalIterations+1):
                iterations.append(self.cycleRecord[(20+n*40)-1])
            for ind,score in enumerate(iterations):
                if ind == 0:
                    total += (score*20)
                    continue
                total += (score*(20+(40*ind)))
        return total

    def addToMap(self, mapLocal):
        if (self.cycle-1-(40*mapLocal)) in [self.signalStrength-1,self.signalStrength,self.signalStrength+1]:
            self.displayMap[mapLocal].append("#")
            return
        self.displayMap[mapLocal].append('.')
        

    def startUp(self):
        sleep = False
        sleepSteps = 0
        aSleep = False
        addAfterSleep = 0
        mapLocation = 0
        while True:
            self.cycle += 1
            mapLocation = math.floor(self.cycle/40)
            if sleep:
                sleepSteps -= 1
                self.cycleRecord.append(self.signalStrength)
                if sleepSteps == 0:
                    sleep = False
                self.addToMap(mapLocation)
                continue
            self.signalStrength += addAfterSleep
            addAfterSleep = 0
            self.addToMap(mapLocation)
            self.cycleRecord.append(self.signalStrength)
            if self.pointer == len(self.instructions): break
            currentInstructions = self.instructions[self.pointer].split(' ')
            self.pointer += 1
            action,count = self.determineInstructions(currentInstructions)
            if action == 1:
                continue
            elif action == 2:
                sleep = True
                sleepSteps = 1
                addAfterSleep = count
                continue


    

inp = """addx 1
addx 4
noop
noop
addx 30
addx -24
addx -1
noop
addx 4
addx 1
addx 5
addx -4
addx 5
addx 4
addx 1
noop
addx 5
addx -1
addx 5
addx 3
noop
addx -38
addx 9
addx -4
noop
addx 3
noop
addx 2
addx 3
noop
addx 2
addx 3
noop
addx 2
addx 3
noop
addx 2
addx -17
addx 22
addx -2
addx 5
addx 2
addx 3
addx -2
addx -36
noop
addx 5
noop
addx 3
noop
addx 2
addx -5
noop
addx 10
addx 3
addx -2
addx 3
addx 2
addx 4
noop
noop
noop
noop
addx 3
noop
noop
addx 7
addx 1
noop
noop
addx -38
addx 39
addx -32
noop
noop
noop
addx 5
addx 2
addx -1
addx 4
noop
addx 5
addx -2
addx 5
addx 2
addx -26
addx 31
addx -2
addx 4
addx 3
addx -18
addx 19
addx -38
addx 7
noop
noop
addx 34
addx -39
addx 8
addx 5
addx 2
addx 10
addx -5
addx -2
addx 5
addx 2
addx 11
addx -6
noop
addx 3
noop
addx 2
addx 3
addx -2
addx -38
noop
noop
noop
addx 5
addx 11
noop
addx -3
noop
noop
noop
addx 2
noop
addx -11
addx 16
noop
addx 3
addx 2
addx 8
noop
noop
noop
noop
noop
addx 4
addx 3
noop
addx -20
noop"""

inp = inp.split('\n')

clock = CPUClock(inp)
clock.startUp()
for row in clock.displayMap:
    print(row)