import collections

class mystring:
    def __init__(self,string:str):
        self.string=string
        string=string.replace('.',' ')
        self.frequency=collections.Counter(string.split())
        self.frequency = dict(sorted(self.frequency.items(),key = lambda kv: kv[1],reverse=True))

    def most_common(self):
        key=list(self.frequency.keys())[0]
        if(self.frequency[key]>1):
            return key
        return 'No repetation'

    def length_of_repeated_words(self):
        count=0
        for key in self.frequency.keys():
            if(self.frequency[key]>1):
                count+=(len(key)*self.frequency[key])
        return count

    def __len__(self):
        print('Length of the text is : ',len(self.string))
        return self.length_of_repeated_words()


string=input('Enter the text : \n')
ms=mystring(string)
count=len(ms)
print('Total length of repetative words (Ignoring white space) : ',count)
print('Most frequently occuring word : ',ms.most_common(),'\n')