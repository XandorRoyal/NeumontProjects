inp = """Sabqponm
abcryxxl
accszExk
acctuvwj
abdefghi"""

sub=96

class Node:
    def __init__(self, parent, position, height) -> None:
        self.Parent = parent
        self.Position = position

        self.Height = height

        self.G = 0
        self.H = 0
        self.F = 0
    
    def __eq__(self, other) -> bool:
        return self.Position == other.Position

def astar(grid, start, end):
    startNode = Node(None, start, 1)
    endNode = Node(None, end, 26)
    startNode.G = startNode.H = startNode.F = 0
    endNode.G = endNode.H = endNode.F = 0

    openList = []
    closedList = []

    openList.append(startNode)

    while len(openList) > 0:
        currentNode = openList[0]
        currentIndex = 0

        for index, item in enumerate(openList):
            if item.F < currentNode.F:
                currentNode = item
                currentIndex = index
        
        openList.pop(currentIndex)
        closedList.append(currentNode)


        if currentNode == endNode:
            path = []
            current = currentNode
            while current is not None:
                path.append(current.Position)
                current = current.Parent
            return path[::-1]

        children = []
        for newPos in [(0,-1),(0,1),(-1,0),(1,0)]:
            nodePos = (currentNode.Position[0]+newPos[0], currentNode.Position[1]+newPos[1])

            if nodePos[0] > (len(grid)-1) or nodePos[0] < 0 or nodePos[1] > (len(grid[len(grid)-1])-1) or nodePos[1] < 0:
                continue

            nodeHeight = ord(grid[nodePos[0]][nodePos[1]])

            if nodeHeight-sub > 1+currentNode.Height:
                continue

            newNode = Node(currentNode, nodePos, nodeHeight)
            
            children.append(newNode)

        for child in children:
            if child in closedList: continue

            child.G = currentNode.G+1
            child.H = ((child.Position[0] - endNode.Position[0]) ** 2)+ ((child.Position[1] - endNode.Position[1]) ** 2)
            child.F = child.G + child.H

            for open in openList:
                if child == open and child.G > open.G:
                    continue
            print(child.Position)
            openList.append(child)

inp = inp.split('\n')
g = []
for ind,r in enumerate(inp):
    g.append([*r])

start = (0,0)
end = (0,0)
for yNum,r in enumerate(inp):
    for xNum,char in enumerate(r):
        if char == 'S':
            start = (xNum,yNum)
        elif char == 'E':
            end = (xNum,yNum)
print(start,end)
path = astar(inp,start,end)
print(path)