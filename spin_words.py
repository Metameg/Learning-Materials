def spin_words(sentence):
    # Your code goes here
    words = sentence.split();
    ans = [];
    
    for i in words:
        if len(i) >= 5:
            ans.append(i[::-1])
        else:
            ans.append(i)
    return " ".join(ans);

print(spin_words("Welcome"))