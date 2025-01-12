n = int(input())
visited = [0] * n
result = []

def recursive(idx):
    
    if idx == n:
        print(*result)
        return
    
    for i in range(0,n):
        if not visited[i]:
            visited[i] = 1
            result.append(i+1)
            recursive(idx+1)
            result.pop()
            visited[i] = 0

recursive(0)