Some of the problems I have encountered:

1. The signature of the MusicServiceImpl constructor was getting a bit ridiculous, so when it came to adding a new singleton (TextFileStoreImpl), my initial thought was to do it traditionally via constructor, but I instead chose to create a new instance of the singleton inside the constructor (Line 28 of MusicServiceImpl.java). Is this good practice? If not, why?

2. The test we had to add to MusicServiceImplTest called canAddFilesThenSaveThenLoad() requires me to create a new instance of MusicServiceImpl and populate it with the 18 Mp3 Files, however, the testAddAllMp3Media() method already does this and I was wondering if it was right for me to be able to push that single instance as a member variable and continue like that?

3. The test called canAddFilesThenSaveThenLoad() that I have to code myself throws an JsonMappingException error when I call the marshal method, saying that there has been no serializer found. Also, when it comes to loading an object from a text file, is it safe to assume that I would have to create a new MusicServiceImpl to load on to it or somehow unpopulate the first one (Line 31 of MusicServiceTest.java)

