package com.example.myapplication;
import java.io.StringReader;
import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.trees.Tree;

public class NLP {
public Tree parse(String str){
    //LexicalizedParser parser = LexicalizedParser.loadModel("C:\\Users\\CodeC\\Desktop\\fff\\edu\\stanford\\nlp\\models\\lexparser\\englishPCFG.ser.gz");
    LexicalizedParser parser = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
    List<CoreLabel> tokens = tokenize(str);
        parser.apply(tokens);
        return null;
}
    public List<CoreLabel> tokenize(String str) {
        TokenizerFactory<CoreLabel> tokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(), "invertible = True");
        Tokenizer<CoreLabel> tokenizer = tokenizerFactory.getTokenizer(new StringReader(str));
        return tokenizer.tokenize();

    }
}
