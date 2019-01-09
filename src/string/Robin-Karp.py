class Solution:
    """
    @param: source: A source string
    @param: target: A target string
    @return: An integer as index
    """
    def strStr2(self, source, target):
        if source is None or target is None:
            return -1
        targetLen = len(target)
        sourceLen = len(source)
        
        if targetLen == 0:
            return 0
        
        if sourceLen == 0:
            return -1
        
        self.base = 1000000
        self.MOD = 31
        power = 1
        
        # 31^targetLen
        for i in range(targetLen):
            power = ( power * self.MOD ) % self.base
        
        # Compute TargerHashCode
        TargerHashCode = 0 
        for i in range(targetLen):
            TargerHashCode = ( TargerHashCode * self.MOD + ord(target[i]) ) % self.base
            if TargerHashCode < 0:
                TargerHashCode += self.base
        
        
        # Compute SourceHashCode
        SourceHashCode = 0
        for i in range(sourceLen):
            # abc + d
            SourceHashCode = ( SourceHashCode * self.MOD + ord(source[i]) )  % self.base
            if i < targetLen - 1:
                continue
            
            if i >= targetLen:
                SourceHashCode = ( SourceHashCode - ord(source[i-targetLen]) * power ) % self.base
                if SourceHashCode < 0:
                    SourceHashCode += self.base
                
            
            if SourceHashCode == TargerHashCode:
                if source[i-targetLen+1:i+1] == target:
                    return i-targetLen+1
                    
        return -1