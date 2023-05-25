def remAll(l, item):
    answer = []
    for i in l:
        if i!=item:
            answer.append(i)
    return answer

print("enter expression")

def ev_expr(string):
    if string[:1] == "-":
        string = "0"+string
        
    string = string.replace("(", "")
    string = string.replace(")", "")

    while "+-" in string or "+-" in string or "--" in string or "*-" in string or "/-" in string:
        string = string.replace("+-", "-")
        string = string.replace("--", "+")
        string = string.replace("++", "+")
        string = string.replace("*-", "@")
        string = string.replace("/-", "¤")

    temp_str = string

    add_chars = "+-"

    mul_chars ="*/@¤"


    for c in add_chars:   
        temp_str = temp_str.replace(c, "#")

    numbers= [i for i in temp_str.split("#")]

    numbers = remAll(numbers, "")

    operators =  [i for i in string if not i.isdigit()]

    operators = remAll(operators, "*")
    operators = remAll(operators, "/")
    operators = remAll(operators, ".")
    operators = remAll(operators, "@")
    operators = remAll(operators, "¤")

    numbers_to_add = []

    b = 0
    
    for i in range(len(numbers)):
        num = numbers[i]
        for c in mul_chars:
            num = num.replace(c, "#")
        nums = [float(j) for j in num.split("#")]
        ops = [j for j in numbers[i] if not j.isdigit()]
        ops = remAll(ops, ".")
        sum = nums[0]
        for j in range(len(ops)):
            if ops[j] == "@":
                sum *= nums[j+1]*-1
            elif ops[j] == "¤":
                sum /= nums[j+1]*-1
            elif ops[j] == "*":
                sum *= nums[j+1]
            elif ops[j] == "/":
                sum /= nums[j+1]
        numbers_to_add.insert(i, sum)

    sum = numbers_to_add[0]
    for i in range(len(operators)):
        if operators[i] == "+":
            sum += numbers_to_add[i+1]
        elif operators[i] == "-":
            sum -= numbers_to_add[i+1]
    return sum

def evaluate(string):
    string = string.replace(" ", "")
    while "(" in string:
        string = string.replace("*-(-", "*(")
        string = string.replace(" ", "")
        string = string.replace("(", "#(")
        string = string.replace(")", ")#")

        split_expresion = [i for i in string.split("#")]

        for i in range(len(split_expresion)):
            if len(split_expresion[i]) > 0 and split_expresion[i][0] == "(" and split_expresion[i][-1] == ")":
                temp = split_expresion[i][1:-1]
                split_expresion[i] = str(ev_expr(temp))
                if i > 0 and len(split_expresion[i-1]) > 0 and split_expresion[i-1][-1].isdigit() :
                    split_expresion[i] = "*"+split_expresion[i]
                
        string = "".join(split_expresion)

    return ev_expr(string)

def calc(string):
    print(string)
    try:
        return evaluate(string)
    except:
        print("should be wrong?")
        return evaluate(string.replace("-","0-"))
