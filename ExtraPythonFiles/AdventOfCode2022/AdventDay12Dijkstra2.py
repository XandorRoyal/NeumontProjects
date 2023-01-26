import time
inp = """Sabqponm
abcryxxl
accszExk
acctuvwj
abdefghi"""

grid = inp.split('\n')
for ind,i in enumerate(grid):
    grid[ind] = [*i]

nodeGrid = []
sub=96

class Node:
    def __init__(self, coords, num) -> None:
        self.Coords = coords
        self.Num = ord(num)-sub
        if self.Num == -27:
            self.Num = 26
        self.Steps = 0
        self.children = []
    
    def add_child(self, coord, char):
        weight = 1
        num = ord(char)-sub
        if num == -27:
            num = 26
        if num == 1:
            weight = -1
        if num > self.Num+1:
            weight = -2
            if self.Num == -13:
                weight=1
            #if weight == -2: 
        self.children.append((coord,weight))

start = None
end = None

for yNum,row in enumerate(grid):
    nodeGrid.append([])
    for xNum,point in enumerate(row):
        char = grid[yNum][xNum] 
        newNode = Node((xNum,yNum), char)
        if yNum != 0:
            newNode.add_child((xNum,yNum-1),grid[yNum-1][xNum])
        if yNum != len(grid)-1:
            newNode.add_child((xNum,yNum+1),grid[yNum+1][xNum])
        if xNum != 0:
            newNode.add_child((xNum-1,yNum),grid[yNum][xNum-1])
        if xNum != len(grid[yNum])-1:
            newNode.add_child((xNum+1,yNum),grid[yNum][xNum+1])
        nodeGrid[yNum].append(newNode)
        if char == 'S':
            start = newNode
        elif char == 'E':
            end = newNode
"""
count=-1
def dijkstraAlgorithm(node, steps):
    #if node in visited: return
    visited.append(node)
    steps+=1
    node.Steps = steps
    for child in node.children:
        childCoord = child[0]
        childWeight = child[1]
        childNode = nodeGrid[childCoord[1]][childCoord[0]]
        if childWeight == -1: continue
        if childNode in visited: continue
        dijkstraAlgorithm(nodeGrid[childCoord[1]][childCoord[0]],steps)
"""

def printMap():
    print('---------------')
    for row in nodeGrid:
        nodeOutput = []
        for node in row:
            nodeOutput.append(node.Steps)
        print(nodeOutput)

currentNode = start
visited = []
line = []
while 1:
    visited.append(currentNode)
    if currentNode not in line:
        line.append(currentNode)
    if currentNode.Steps == 0:
        currentNode.Steps = line.index(currentNode)
    c = False
    for child in currentNode.children:
        childCoord = child[0]
        childWeight = child[1]
        childNode = nodeGrid[childCoord[1]][childCoord[0]]
        if childWeight == -2: continue
        if childNode in visited: continue
        currentNode = childNode
        c = True
    if c:
        continue
    line.pop()
    currentNode = line[-1]
    if len(line) == 1:
        break
    


#dijkstraAlgorithm(start,count)
print(end.Steps)
printMap()
