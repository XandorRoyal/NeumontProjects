
filePath = './time.txt'

def getTime():
    with open(filePath,'r') as File:
        minutes = 0
        seconds = 0
        for row in File:
            if row.find('(') > -1 and row.find(')') > -1:
                sub = row[row.find('(')+1:row.find(')')]
                minLoc = sub.find('m')
                secLoc = sub.find('s')
                if minLoc > -1:
                    minutes += int(sub[0:minLoc])
                else:
                    print('sss')
                    seconds += int(sub[0:secLoc])
                if secLoc > -1 and minLoc > -1:
                    print(int(sub[minLoc+1:secLoc]))
                    seconds += int(sub[minLoc+1:secLoc])
        print(seconds)
        minutes += seconds//60
        seconds = seconds % 60
        return [minutes,seconds]
                

if __name__ == '__main__':
    t = getTime()
    min,sec = t[0],t[1]
    print(min,sec)