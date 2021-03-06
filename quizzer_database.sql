-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: localhost    Database: quizzer
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `domain`
--

DROP TABLE IF EXISTS `domain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domain`
--

LOCK TABLES `domain` WRITE;
/*!40000 ALTER TABLE `domain` DISABLE KEYS */;
INSERT INTO `domain` VALUES (1,'BIOLOGY'),(2,'HISTORY'),(3,'GEOGRAPHY');
/*!40000 ALTER TABLE `domain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level1`
--

DROP TABLE IF EXISTS `level1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level1`
--

LOCK TABLES `level1` WRITE;
/*!40000 ALTER TABLE `level1` DISABLE KEYS */;
INSERT INTO `level1` VALUES (12,'BIOLOGY','Ordinary table salt is sodium chloride. What is baking soda?','Sodium bicarbonate','Potassium chloride','Potassium carbonate','Sodium bicarbonate'),(13,'BIOLOGY','Ozone hole refers to','decrease in thickness of ozone layer','hole in ozone layer','decrease in the ozone layer in troposphere','decrease in thickness of ozone layer'),(14,'BIOLOGY','Pine, fir, spruce, cedar, larch and cypress belong to','gymnosperms','monocotyledons','angiosperms','gymnosperms'),(15,'BIOLOGY','Pollination is best defined as','transfer of pollen from anther to stigma','germination of pollen grains','growth of pollen tube in ovule','transfer of pollen from anther to stigma'),(16,'BIOLOGY','Plants receive their nutrients mainly from','soil','chlorophyll','atmosphere','soil'),(17,'BIOLOGY','Movement of cell against concentration gradient is called ','active transport','osmosis','diffusion','active transport'),(18,'BIOLOGY','Photosynthesis generally takes place in which parts of the plant?','Leaf and other chloroplast bearing parts','stem and leaf','Roots and chloroplast bearing parts','Leaf and other chloroplast bearing parts'),(19,'BIOLOGY','Most fish do not sink in water because of the presence of','air bladder','air sacs','air in spongy bones','air bladder'),(20,'BIOLOGY','Plants synthesis protein from','amino acids','sugar','fatty acids','amino acids'),(21,'BIOLOGY','Plants absorb dissolved nitrates from soil and convert them into','free nitrogen','urea','proteins','free nitrogen'),(22,'BIOLOGY','The vast and dominant woodlands in Europe, Asia, North America have','only conifers','only angiosperms','other','only conifers'),(23,'BIOLOGY','One of the following is not a function of bones','Secretion of hormones for calcium','Place for muscle attachment','Production of blood corpuscles','Secretion of hormones for calcium'),(24,'HISTORY','Rivers Tigris and Euphrates are associated with ?','Mesopotamian Civilization','Egyptain Civilization','Chinese Civilization','Mesopotamian Civilization'),(25,'HISTORY','Which is considered as oldest civilization of the world ?','Mesopotamian Civilization','Egyptain Civilization','Chinese Civilization','Mesopotamian Civilization'),(26,'HISTORY','Which among following is called \"Gift of the Nile\" ?','Egypt','China','India','Egypt'),(27,'HISTORY','Who is considered as the master of Greek comedy ?','Aristophanes','Aeschylus','Sophocles','Aristophanes'),(28,'HISTORY','When ancient Olympic games first held ?','776 BC','780 BC','790 BC','776 BC'),(29,'HISTORY','Who is known as the father of Modern Medicine ?','Hippocrates','Euclid','Erastosthenes','Hippocrates'),(30,'HISTORY','Rome was founded around ?','1000 BC','1200 BC','1400 BC','1000 BC'),(31,'HISTORY',' Which was not an Roman Philosopher ?','Octavian','Cicero','Seneca','Octavian'),(32,'HISTORY','Who was among the famous Roman poets ?','Virgil','Marcus','Tacitus','Virgil'),(33,'HISTORY','Marco Polo, Venetian traveller, travelled from Venice to China and Japan in :','1288 - 93','1285 - 90','1295 - 1301','1288 - 93'),(34,'GEOGRAPHY','The latitudinal differences in pressure delineate a number of major pressure zones, which correspond with','zones of climate','zones of oceans','zones of land','zones of climate'),(35,'GEOGRAPHY','The higher the wind speed and the longer the distance across waves travel, the ____ waves and the ____ energy they process.','larger, more','larger, less','smaller, more','larger, more'),(36,'GEOGRAPHY','The hazards of radiation belts include','damage of solar cells of spacecraft','adverse effect on living organisms','deterioration of electronic circuits','damage of solar cells of spacecraft'),(37,'GEOGRAPHY','The great Victoria Desert is located in','Australia','West Africa','North America','Australia'),(38,'GEOGRAPHY','The intersecting lines drawn on maps and globes are','geographic grids','longitudes','latitudes','geographic grids'),(39,'GEOGRAPHY','The light of distant stars is affected by','the earth\'s atmosphere and inetrstellar dust','interstellar dust','the earth\'s atmosphere','the earth\'s atmosphere and inetrstellar dust'),(40,'GEOGRAPHY','The landmass of which of the following continents is the least?','Australia','Asia','Africa','Australia'),(41,'GEOGRAPHY','Without ____ the equator would be much hotter than it is while the poles would be much cooler.','cycle of air circulation and global wind pattern','cycle of air circulation','global wind pattern','cycle of air circulation and global wind pattern'),(42,'GEOGRAPHY','The habitats valuable for commercially harvested species are called','sea grass bed','hot spots','coral reefs','sea grass bed'),(43,'GEOGRAPHY','Which of the following is tropical grassland?','Savannah','Pampas','Taiga','Savannah');
/*!40000 ALTER TABLE `level1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level2`
--

DROP TABLE IF EXISTS `level2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level2`
--

LOCK TABLES `level2` WRITE;
/*!40000 ALTER TABLE `level2` DISABLE KEYS */;
INSERT INTO `level2` VALUES (11,'BIOLOGY','Plants absorb most part of water needed by them through their','root hairs','embryonic zone','growing point','root hairs'),(12,'BIOLOGY','Photo-oxidation is','light and oxygen induced breakdown','photo-growth','lipolysis','light and oxygen induced breakdown'),(13,'BIOLOGY','Process of cell division can take place by','mitosis','heterosis','fusion','mitosis'),(14,'BIOLOGY','Most highly intelligent mammals are','dolphins','whales','elephants','dolphins'),(15,'BIOLOGY','Plant development is influenced by','quality, quantity and duration of light','quality of light only','quality and quantity of light','quality, quantity and duration of light'),(16,'BIOLOGY','Prokaryotic cells lack','both nuclear membrane and nucleolus','nuclear membrane','nucleolus','both nuclear membrane and nucleolus'),(17,'BIOLOGY','Photosynthesis takes place faster in','white light','yellow light','red light','white light'),(18,'BIOLOGY','Nucleus, the genetic material containing rounded body in each cell, was discovered by','Robert Brown','Robert Hooke','Theodore Schwann','Robert Brown'),(19,'BIOLOGY','Primary phloem develops from','provascular tissue','lateral meristem','protoderm','provascular tissue'),(20,'BIOLOGY','Other than spreading malaria, anopheles mosquitoes are also vectors of','filariasis','dengue fever','encephalitis','filariasis'),(21,'BIOLOGY','Plants that grow in saline water are called','halophytes','hydrophytes','mesophytes','halophytes'),(22,'BIOLOGY','Pyorrhoea is a disease of the','gums','nose','heart','gums'),(23,'HISTORY','In which year Bartholomew Diaz reached Cape of Good Hope ?','1487','1500','1495','1487'),(24,'HISTORY','Vasco da Gama reached in India in he year ?','1498','1495','1496','1498'),(25,'HISTORY','Who was the first to sail round the world ?','Magellan','Columbus','Vasco da Gama','Magellan'),(26,'HISTORY','America was discovered in ?','1492','1493','1491','1492'),(27,'HISTORY','Brazil was discovered in ?','1500','1505','1515','1500'),(28,'HISTORY','Who discovered North Pole ?','Robert Peary',' Magellan','Amundsen','Robert Peary'),(29,'HISTORY','Magna Carta or The Great Charter was signed in','1215','1225','1210','1215'),(30,'HISTORY','Habeas Corpus Act was passed in ?','1679','1683','1691','1679'),(31,'HISTORY','\"Boston Tea Party\" incident happened in ?','1773','1771','1770','1773'),(32,'HISTORY',' In which year American Revolution started ?','1775','1776','1774','1775'),(33,'GEOGRAPHY','The iron and steel industries of which of the following countries are almost fully dependent on imported raw materials?','Japan','Poland','Britain','Japan'),(34,'GEOGRAPHY','The temperature increases rapidly after','ionosphere','exosphere','stratosphere','ionosphere'),(35,'GEOGRAPHY','The humidity of the air depends upon','temperature and water','temperature','water','temperature and water'),(36,'GEOGRAPHY','The groundwater can become confined between two impermeable layers. This type of enclosed water is called','artesian','unconfined groundwater','confined groundwater','artesian'),(37,'GEOGRAPHY','The largest glaciers are','continental glaciers','alpine glaciers','mountain glaciers','continental glaciers'),(38,'GEOGRAPHY','The ionosphere includes','thermosphere and exosphere','thermosphere','mesosphere','thermosphere and exosphere'),(40,'GEOGRAPHY','The subatomic particles arriving from outer space having high energy are called','cosmic rays','electrons','protons','cosmic rays'),(41,'GEOGRAPHY','The strongest bonds exist between the particles found within','igneous rocks','sedimentary rock','metamorphic rocks','igneous rocks'),(42,'GEOGRAPHY','The highest degree of concentration of mineral deposits are found in','northeastern zone','northwestern zone','southern zone','northeastern zone'),(43,'GEOGRAPHY','The group of minerals chemically containing hydrocarbons is','organic group','silicate group','oxide group','organic group');
/*!40000 ALTER TABLE `level2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level3`
--

DROP TABLE IF EXISTS `level3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level3`
--

LOCK TABLES `level3` WRITE;
/*!40000 ALTER TABLE `level3` DISABLE KEYS */;
INSERT INTO `level3` VALUES (12,'BIOLOGY','Oxygen released in the process of photosynthesis comes from','water','sugar','pyruvic acid','water'),(13,'BIOLOGY','Placenta is the structure formed','by the union of foetal and uterine tissue','by foetus only','by fusion of germ layers','by the union of foetal and uterine tissue'),(14,'BIOLOGY','Plants hormone that induces cell division is','kinins','auxins','gibberellins','kinins'),(15,'BIOLOGY','Neurospora is used as genetic material because','it has short life cycle of 10 days','can be easily analysed','is a diploid fungus','it has short life cycle of 10 days'),(16,'BIOLOGY','Phloem is a tissue found in','plants','insects','mammals','plants'),(17,'BIOLOGY','out of proteins, lipids and carbohydrates present in a cell membrane, what is true?','Carbohydrates are minimum','Carbohydrates are maximum','Lipids are maximum','Carbohydrates are minimum'),(18,'BIOLOGY','Potato is a modified form (outgrowth) of','stem','fruit','leaf','stem'),(19,'BIOLOGY','Of the following taxonomic categories which is the most inclusive?','Class','Subspecies','Order','Class'),(20,'BIOLOGY','Prothrombin which helps in clotting of blood is released by','blood platelets','erythrocytes','lymphocytes','blood platelets'),(21,'BIOLOGY','Myopia is connected with','eyes','lungs','ears','eyes'),(22,'BIOLOGY','Most of the red, blue and purple colours of plants are due to a pigment called','anthocyanin','carotene','chlorophyll','anthocyanin'),(23,'HISTORY',' In which year American Independence was acknowledged by England ?','1783','1782','1799','1783'),(24,'HISTORY','French Revolution was started in the Year ?','1789','1777','1785','1789'),(25,'HISTORY','Young Italy movement by led by two revolutionaries, One was \"Mazzini\" and Other was ?','Garibaldi','Victor','Louis','Garibaldi'),(26,'HISTORY','Rome was liberated by the Italian soldiers in the year ?','1870','1856','1875','1870'),(27,'HISTORY','When did World War 2 start ?','1939','1937','1941','1939'),(28,'HISTORY','When was Bulkan War II fought ?','1913','1912','1915','1913'),(29,'HISTORY','Who is known as Man of Blood and Iron ?','Bismarck','Sir Walter Scott','Napoleon','Bismarck'),(30,'HISTORY','In which year Hitler became the Chancellor of Germany ?','1933','1937','1939','1933'),(31,'HISTORY','Who was the author of the \"American Declaration of Independence\" ?','Jefferson','George Washington','Thomas Paine','Jefferson'),(32,'HISTORY','The Renaissance scientist who explained how planets moved around the sun was ?','Kepler','Gutenberg','Rebelais','Kepler'),(33,'GEOGRAPHY','The iron ore mined at Bailadila is mostly','haematite','siderite','limonite','haematite'),(34,'GEOGRAPHY','The leading state in producing paper is','West Bengal','Bihar','Kerala','West Bengal'),(35,'GEOGRAPHY','The largest dune files are found in','Middle East and North Africa','North Africa','Middle East','Middle East and North Africa'),(36,'GEOGRAPHY','The minimum values of annual receipts of solar radiation occur at','the arctic','the tropics','the equator','the arctic'),(37,'GEOGRAPHY','The largest gold producing country in the world(in 2006) is','South Africa','Canada','China','South Africa'),(38,'GEOGRAPHY','The least explosive type of volcano is called','Basalt plateau','Cinder cone','Shield volcanoes','Basalt plateau'),(39,'GEOGRAPHY','The main percentage of the volume of water in the hydrosphere is in','oceans and seas','groundwater\'s, rivers and streams','glaciers and ice sheets','oceans and seas'),(40,'GEOGRAPHY','The largest fish exporting region in the world is','the north-east atlantic region','the north-east pacific region','the north-west pacific region','the north-east atlantic region'),(41,'GEOGRAPHY','The largest country of the world by geographical area is','Russia','Vatican City','Australia','Russia'),(42,'GEOGRAPHY','The hot and cold deserts together occupy nearly ____ land area of the world.','1/3rd','1/2','3/4th','1/3rd');
/*!40000 ALTER TABLE `level3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level4`
--

DROP TABLE IF EXISTS `level4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level4` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level4`
--

LOCK TABLES `level4` WRITE;
/*!40000 ALTER TABLE `level4` DISABLE KEYS */;
INSERT INTO `level4` VALUES (11,'BIOLOGY','Plants developing in dry conditions are','xerophytes','mesophytes','hydrophytes','xerophytes'),(12,'BIOLOGY','Plants growing on sand are called as','psammophytes','oxylophytes','lithophytes','psammophytes'),(13,'BIOLOGY','Our skin, when exposed to excess sunlight, becomes dark. This is because our skin pigments called','melanin','carotene','flavoxanthin','melanin'),(14,'BIOLOGY','Ramapithecus and Cro-Magnon man are considered','ancestors of modern man','ancestors of monkey','ancestors of lion','ancestors of modern man'),(15,'BIOLOGY','Normal adult human male has per 100 gr of blood around','14 gram of haemoglobin','10 gram of haemoglobin','	24 gram of haemoglobin','14 gram of haemoglobin'),(16,'BIOLOGY','Plants wilt due to excess of','transpiration','photosynthesis','absorption','transpiration'),(17,'BIOLOGY','Monotremes are unique mammals because they','lay eggs','give birth to live young','secret milk in a pouch','lay eggs'),(18,'BIOLOGY','Poison glands of snakes are homologous to','salivary glands of vertebrates','stings of rays','electric organs of fishes','salivary glands of vertebrates'),(19,'BIOLOGY','Plant bends towards the source of light on account of the movement of curvature known as','phototropism','geotropism','chemotropism','phototropism'),(20,'BIOLOGY','Plant have ____ while animals lack it.','cellulose','protein','fat','cellulose'),(21,'HISTORY','Russian revolutionary, who founded the Communist Party was','Lenin','Karl Marx','Stalin','Lenin'),(22,'HISTORY','Who is also known as the founder of scientific socialism ?','Karl Marx','Lenin','Rousseau','Karl Marx'),(23,'HISTORY','Who said that \" Man is a political animal\" ?','Aristotle','Karl Marx','Plato','Aristotle'),(24,'HISTORY',' In which country Aztec civilization was originated ?','Mexico','USA','Greece','Mexico'),(25,'HISTORY','Who was the Emperor of Russia during Russia revolution ?','Nicholas II','Alexander I','Lenin','Nicholas II'),(26,'HISTORY','What is the name first Roman Emperor ?','Augustus','Caligula','Claudius','Augustus'),(27,'HISTORY','Who is known as \"Father of History\" ?','Herodotus','Homer','Nero','Herodotus'),(28,'HISTORY','What is the name of autobiography of Adolf Hitler ?','Mein Kampf','My Spirit','First Attack','Mein Kampf'),(29,'HISTORY','Who was the last Emperor of Rome ?','Romulus Augustulus','Nero','Julius','Romulus Augustulus'),(30,'HISTORY',' The Parliament of Great Britain was formed in the year ?','1707','1708','1705','1707'),(31,'GEOGRAPHY','The highest average salinity amongst the following seas is reported from','Dead Sea','Red Sea','Black Sea','Dead Sea'),(32,'GEOGRAPHY','The Himalayan mountain system belongs to which of the following?','Fold mountains','Block mountains','Residual mountains','Fold mountains'),(33,'GEOGRAPHY','The heavy day soils that show significant expansion and contraction due to the presence or absence of moisture is called','vertisols','histosols','aridsols','vertisols'),(34,'GEOGRAPHY','The HBJ Upgradation project, upgraded the capacity of HBJ pipeline from 18.2 MM SC MD to','33.4 MM SC MD','22.3 MM SC MD','29.6 MM SC MD','33.4 MM SC MD'),(35,'GEOGRAPHY','The highest mountains on earth namely Mount Everest, K2, Kanchenjanga are located in','the greater Himalayas','the Lesser Himalayas','the outer Himalayas','the greater Himalayas'),(36,'GEOGRAPHY','The infrared radiation by sun are strongly absorbed by','carbon dioxide','water vapours','ozone','carbon dioxide'),(37,'GEOGRAPHY','The latitude of a place expresses its angular position relative to the plane of','equator','south pole ','north pole','equator'),(38,'GEOGRAPHY','The landforms that are influences by several process namely, weathering, erosion, deposition are known as','polygenetic landforms','structural landforms','polycyclic landforms','polygenetic landforms'),(39,'GEOGRAPHY','The longest epoch of the tertiary period is','Eocene','Oligocene','Palaeocene','Eocene'),(40,'GEOGRAPHY','The island state of Australia is','Tasmania','Victoria','Queensland','Tasmania');
/*!40000 ALTER TABLE `level4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level5`
--

DROP TABLE IF EXISTS `level5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level5` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level5`
--

LOCK TABLES `level5` WRITE;
/*!40000 ALTER TABLE `level5` DISABLE KEYS */;
INSERT INTO `level5` VALUES (11,'BIOLOGY','Photosynthesis is a process','reductive, endergonic and anabolic','reductive and exergonic','reductive and catabolic','reductive, endergonic and anabolic'),(12,'BIOLOGY','On which of the following plants did Gregor Mendal perform his classical experiment?','Pea','Wheat','Maize','Pea'),(13,'BIOLOGY','Pigmentation of skin is due to','melanocytes','lymphocytes','leucocytes','melanocytes'),(14,'BIOLOGY','Norepinephrine increases','blood pressure','saliva production','respiration','blood pressure'),(15,'BIOLOGY','Night blindness is cause by lack of which vitamin?','Vitamin A','Vitamin B','Vitamin D','Vitamin A'),(16,'BIOLOGY','Monocot root differs from dicot root in having','well developed pith','open vascular bundles','scattered vascular bundles','well developed pith'),(17,'BIOLOGY','Radioactivity is a phenomenon of the spontaneous emission of','protons, electrons and gamma rays','protons','gamma rays','protons, electrons and gamma rays'),(18,'BIOLOGY','Organic Substances which, in very small amounts, control growth and development called','hormones','enzymes','vitamins','hormones'),(19,'BIOLOGY','Our major foods, fibres, spices, fruits and beverage crops are','flowering plants','pteridophytes','bryophytes','flowering plants'),(20,'BIOLOGY','Movements due to light are shown by','flowering plants','lower plants','all land plants','flowering plants'),(21,'BIOLOGY','Outer covering of virus made up of protein is','capsid','coat','virion','capsid'),(22,'BIOLOGY','Radish is a','modified root','bulb','tuber','modified root'),(23,'HISTORY','The historical monument Al Khazneh is located in which city ?','Petra','Baghdad','Giza','Petra'),(24,'HISTORY','Who started the construction of Colosseum in Rome ?','Vespasian','Titus','Victor','Vespasian'),(25,'HISTORY','The first news paper in the world was started by ?','China','USA','Japan','China'),(26,'HISTORY','Adolf Hitler committed suicide in ?','1945','1947','1944','1945'),(27,'HISTORY','Before independence Ukraine was part of ?','USSR','China','None','USSR'),(28,'HISTORY',' First World War started in which year ?','1914','1916','1924','1914'),(29,'HISTORY','In 1986 the prime minister of which European country was assassinated on his way home from the cinema with his wife?','Sweden','Greece','Italy','Sweden'),(30,'HISTORY','What was the nickname of President Duvalier of Haiti, who died in 1971? ','Papa Doc','Duva','Castro','Papa Doc'),(31,'HISTORY','Which battle of 1571 marked the end of the Ottoman naval supremacy in the Mediterranean?The Battle of ','Lepanto ','Istanbul','Bosfor','Lepanto '),(32,'HISTORY','Nearly how many years did it take Sir Francis Drake to complete the first circumnavigation of the globe in 1580?','3','2','5','3'),(33,'GEOGRAPHY','The Ice age ended about ____ years ago.','14,000','1,400','140,000','14,000'),(34,'GEOGRAPHY','The languages used in China is','Chinese, English','Chinese, Arabic','Chinese, French','Chinese, English'),(35,'GEOGRAPHY','The islands with coral covered surfaces in Bay of Bengal are','Nicobar islands','Andaman islands','Both of the above','Nicobar islands'),(36,'GEOGRAPHY','Within the transporting medium, transport can occur by','solution and suspension','suspension','solution','solution and suspension'),(37,'GEOGRAPHY','The length of the day is determined in','astronomical units','solar terms','length of the hours','astronomical units'),(38,'GEOGRAPHY','The hot, dry wind on the east or leeward side of the Rocky mountains (North America) is called','the Chinook','the Sirocco','the Harmattan','the Chinook'),(39,'GEOGRAPHY','The islands of Seychelles are located in the','Indian Ocean','Atlantic Ocean','Pacific Ocean','Indian Ocean'),(40,'GEOGRAPHY','The island of Sri Lanka formerly known as','Ceylon','Tasmania','Madagascar','Ceylon'),(41,'GEOGRAPHY','The highest sand dunes are found is','the Sahara desert','the Atacama desert','the Kalahari desert','the Sahara desert'),(42,'GEOGRAPHY','The greatest variety of animal and plant species is fund in','tropical moist forests','tundra regions','temperate grasslands','tropical moist forests'),(43,'GEOGRAPHY','The layer of the earth, immediately below the crust, is called','inner core','outer core','inner mantle','inner core');
/*!40000 ALTER TABLE `level5` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level6`
--

DROP TABLE IF EXISTS `level6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level6` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level6`
--

LOCK TABLES `level6` WRITE;
/*!40000 ALTER TABLE `level6` DISABLE KEYS */;
INSERT INTO `level6` VALUES (11,'BIOLOGY','Most abundant tissues of our body are','connective','muscular','nervous','connective'),(12,'BIOLOGY','Mumps is a disease caused by','virus','bacterium','fungus','virus'),(13,'BIOLOGY','Rain water helps to increase the ____ to some extent.','calcium contents','nitrogen contents','phosphorous contents','calcium contents'),(14,'BIOLOGY','Number of chromosomes in Down\'s syndrome is','47','48','46','47'),(15,'BIOLOGY','Plants are killed in winter by frost because ','of mechanical damage to the tissues','of no photosynthesis ','there is no transpiration','of mechanical damage to the tissues'),(16,'BIOLOGY','One of the following is most suitable for study of mutations','Haploids','Diploids','Polyploid','Haploids'),(17,'BIOLOGY','Pulses are a good source of','proteins','fats','vitamins','proteins'),(18,'BIOLOGY','Oxygen in our blood is transported by a protein named','haemoglobin','keratin','collagen','haemoglobin'),(19,'BIOLOGY','Nymph is the name of young one of','cockroach','housefly','butterfly','cockroach'),(20,'BIOLOGY','Plants that grow under average temperature and moisture are called','mesophytes','hydrophytes','halophytes','mesophytes'),(21,'HISTORY','Name the most famous battle of 1346?','Crecy','Paris','Rome','Crecy'),(22,'HISTORY',' In 1979 which English art historian was exposed as a one-time Soviet spy and stripped of his knighthood? ','Anthony Blunt','Mata Hari','Sean Johnson','Anthony Blunt'),(23,'HISTORY','In 1816 which US state was admitted to the Union as the 20th state?','Mississippi','Kentucky','Oregon','Mississippi'),(24,'HISTORY','In which year did the demolition of the Berlin Wall begin? ','1989','1990','1995','1989'),(25,'HISTORY','Holy Roman Emperor Charles VI created which principality in 1719?','Lichtenstein','Vatican ','Luxembourg','Lichtenstein'),(26,'HISTORY','Saloth Sar, born 19 May 1925, is better known by what name?','Pol Pot','Sally','Sarr','Pol Pot'),(27,'HISTORY','What tax was introduced in England and Wales in 1696 and repealed in 1851?','Window tax','Calf tax','Street tax','Window tax'),(28,'HISTORY','Which book was published in London on April 25th, 1719?','Robinson Crusoe','Jack the Ripper','Sherlock Holmes','Robinson Crusoe'),(29,'HISTORY',' Who founded the Salvation Army in London, 1865?','William Booth','Guy Fawkes','John Booth','William Booth'),(30,'HISTORY','Who designed RegentΓÇÖs Park in London in 1811?','John Nash','William Penn','Diane Thompson','John Nash'),(31,'HISTORY',' Southern Rhodesia became what country in 1980? ','Zimbabwe','Liberia','Niger','Zimbabwe'),(32,'GEOGRAPHY','The highest mountains in Africa, which is not part of any mountains chain, is','Mt. Kilimanjaro','Mt. Aconcagua','Mt. Kosciuszko','Mt. Kilimanjaro'),(33,'GEOGRAPHY','The heavier silicates named as \'Sima\' or silica + magnesium are most abundant in the','ocean floors','core','crust','ocean floors'),(34,'GEOGRAPHY','The imaginary line on the earth\'s surface, which closely follows the 180 ├é┬║ meridian, is called the','International Date Line','Tropic of Cancer','Equator','International Date Line'),(35,'GEOGRAPHY','The largest part of our hydrosphere is','Pacific ocean','Indian Ocean','Antarctica ocean','Pacific ocean'),(36,'GEOGRAPHY','The limit beyond which the stars suffer internal collapse is called the','Chandrasekhar limit','Aurora Borealis','Raman Effect','Chandrasekhar limit'),(37,'GEOGRAPHY','The ground water that occurs when flow of the subterranean water is not confined by the presence of impermeable layers is called','unconfined groundwater','confined groundwater','aquifer','unconfined groundwater'),(38,'GEOGRAPHY','The gulf that separates Finland and Sweden in Europe is','the Gulf of Bothnia','the Gulf of Lions','the Gulf of Genoa','the Gulf of Bothnia'),(39,'GEOGRAPHY','The largest continent in the world is','Asia','Australia','Antarctica','Asia'),(40,'GEOGRAPHY','The landforms that are created by massive earth movements due to place tectonics are called','structural landforms','weathering landforms','erosional landforms','structural landforms'),(41,'GEOGRAPHY','The main watershed of most of the peninsular river lies in the','Western Ghats','Siwalik hills','Aravalli hills','Western Ghats');
/*!40000 ALTER TABLE `level6` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level7`
--

DROP TABLE IF EXISTS `level7`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level7` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(50) NOT NULL,
  `question` varchar(150) NOT NULL,
  `answer1` varchar(150) NOT NULL,
  `answer2` varchar(50) NOT NULL,
  `answer3` varchar(50) NOT NULL,
  `correct` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level7`
--

LOCK TABLES `level7` WRITE;
/*!40000 ALTER TABLE `level7` DISABLE KEYS */;
INSERT INTO `level7` VALUES (11,'BIOLOGY','Oxyreductases, transferases, hydrolases, lyases, isomerases and ligases are all classes of','enzymes','proteins','vitamins','enzymes'),(12,'BIOLOGY','Mutation is','a change that is inherited','a change which affects the parents','responsible for plant growth','a change that is inherited'),(13,'BIOLOGY','Pollination by wind is called','anemophily','hydrophily','entomophily','anemophily'),(14,'BIOLOGY','Pollen grains in plants are produced in','flower','leaves','stem','flower'),(15,'BIOLOGY','Nitrogen is fixed in ecosystems in ways stated below. Which one of the statements below is false?','By denitrification','By cyanobacteria','By fertilizer','By denitrification'),(16,'BIOLOGY','Ptyalin is an enzyme produced in the','salivary glands','thyroid glands','pancreas','salivary glands'),(17,'BIOLOGY','Mycobacterium leprae causes leprosy, Corynebacterium diphtheria causes diphtheria and Vibrio comma causes','cholera','influenza','tetanus','cholera'),(18,'BIOLOGY','Animal without red blood cells is ','Earthworm',' Peacock','Frog','Earthworm'),(19,'BIOLOGY','The phenomenon of summer sleep by animals is called','aestivation','lethargy','hibernation','aestivation'),(20,'BIOLOGY','The energy released by 1 gram of glucose is','4 kcal','6 kcal','3kcal','4 kcal'),(21,'BIOLOGY','Name the blood cells in which nucleus is absent','Blood Platelets','Lymphocytes','Eosinophils','Blood Platelets'),(22,'HISTORY','The first day of which battle was the worst day in the history of the British Army, which suffered 60,000 casualties? Battle of','Somme','Bristol','Loren','Somme'),(23,'HISTORY','Who became president after the assassination of Abraham Lincoln?','Andrew Johnson','Jefferson','Washington','Andrew Johnson'),(24,'HISTORY','Which Egyptian president ordered the seizure of the Suez Canal in 1956? ','President Nassar','President Tuth','President Baliath','President Nassar'),(25,'HISTORY','Which city is normally accepted as being the ancient capital of Wessex?','Winchester','Bristol','Coventry','Winchester'),(26,'HISTORY','In which year was the death of Queen Elizabeth I?','1603','1609','1608','1603'),(27,'HISTORY','In 1297, at which battle did William Wallace defeat the English?Battle of ','Stirling Bridge','Sterling Bridge','Striling Bridge','Stirling Bridge'),(28,'HISTORY','Who discovered the vaccination against smallpox in 1796?','Edward Jenner','Linus Paulin','Karl Marx','Edward Jenner'),(29,'HISTORY','Name the second largest city in Britain during the Black Death?','Bristol','London','Manchester','Bristol'),(30,'HISTORY','In which European city did composer Richard Wagner die in 1883?','Venice','Wien','Paris','Venice'),(31,'HISTORY','What Apollo 13 astronaut contacted Mission Control with the words, ΓÇ£Houston, weΓÇÖve had a problem here..ΓÇ¥ ? ','Jack Swigert','Yuri Gagarin','Neil Armstrong','Jack Swigert'),(32,'HISTORY','Which country did Britain fight in the War of JenkinsΓÇÖs Ear?','Spain','France','Germany','Spain'),(33,'HISTORY','What was the name of the pandemic which killed over 1% of the worldΓÇÖs population in 1918?','Spanish Flu','Black Death','Chicken pox','Spanish Flu'),(34,'GEOGRAPHY','The Homolographic projection has the correct representation of','area ','baring','distance','area '),(35,'GEOGRAPHY','The largest production of mica in Asia is from','India','Myanmar','Malaysia','India'),(36,'GEOGRAPHY','The latitude \'AA\' on the map represents the','Equator','Tropic of Cancer','Tropic of Capricorn','Equator'),(37,'GEOGRAPHY','The largest fresh water lake of Africa, area wise is','lake Victoria','lake Tanganyika','lake Malawi','lake Victoria'),(38,'GEOGRAPHY','The important mountains of Europe include','Alps, Carpathians, Pyrenees, Apennines','Alps, Himalayas, Rock mountains','Andes, Alps, Pyrenees','Alps, Carpathians, Pyrenees, Apennines'),(39,'GEOGRAPHY','The last major glacial period began about 2,000,000 years before present and is commonly known as','Pleistocene or ice age','Paleocene or ice age','Pliocene or ice age','Pleistocene or ice age'),(40,'GEOGRAPHY','The imaginary axis at which the earth rotates remains inclined at an angle of ____ degrees to the plane of earth\'s orbit.','66 1/2','55 1/2','0','66 1/2'),(41,'GEOGRAPHY','The ionosphere contains ionized air that protects the earth from','the falling meteorites','the infrared rays of the sun','the ultraviolet rays of the sun','the falling meteorites'),(42,'GEOGRAPHY','The largest city in Latin America is','Mexico city','Caracas','Rio-de-Janeiro','Mexico city'),(43,'GEOGRAPHY','The highest and lowest values of a weather element observed over the entire period of record are','absolute extremes','average extremes','extremes','absolute extremes'),(45,'GEOGRAPHY','The highest mountain peak of Oceania is','Puncak Jaya, Indonesia.','Mt. Victoria, Papua New Guinea','Mt. Kosciusko, Australia','Puncak Jaya, Indonesia.'),(46,'GEOGRAPHY','The largest gulf in the world is','Gulf of Mexico','Persian Gulf','Gulf of Carpentaria','Gulf of Mexico');
/*!40000 ALTER TABLE `level7` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `domain` varchar(50) NOT NULL,
  `first` varchar(50) NOT NULL,
  `currlevel` varchar(30) DEFAULT NULL,
  `last1` varchar(50) NOT NULL,
  `last2` varchar(50) NOT NULL,
  `last3` varchar(50) NOT NULL,
  `accountNonExpired` int(11) NOT NULL DEFAULT '1',
  `accountNonLocked` int(11) NOT NULL DEFAULT '1',
  `credentialsNonExpired` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10017 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10000,'user','user','USER','ACTIVE','BIOLOGY','NO','1','89','60','75',1,1,1),(10001,'admin','admin','ADMIN','ACTIVE','BIOLOGY','NO','3','0','0','0',1,1,1),(10003,'player','player','USER','ACTIVE','BIOLOGY','NO','3','29','56','72',1,1,1),(10004,'testing','testing8','USER','INACTIVE','GEOGRAPHY','NO','1','89','60','75',1,1,1),(10005,'test1','test1','USER','ACTIVE','BIOLOGY','YES','3','0','0','0',1,1,1),(10006,'test2','test2','USER','ACTIVE','BIOLOGY','NO','5','0','0','0',1,1,1),(10007,'test3','test3','USER','ACTIVE','BIOLOGY','YES','4','0','0','0',1,1,1),(10008,'test5','test5','USER','ACTIVE','BIOLOGY','NO','5','4.0','3.0','0',1,1,1),(10009,'test6','test6','USER','ACTIVE','GEOGRAPHY','YES','1','5.0','5.0','0',1,1,1),(10010,'test7','test7','USER','ACTIVE','BIOLOGY','NO','6','0','0','0',1,1,1),(10011,'test8','test8','USER','ACTIVE','BIOLOGY','NO','7','0.0','0','0',1,1,1),(10012,'test9','test9','USER','ACTIVE','BIOLOGY','YES','1','0','0','0',1,1,1),(10013,'testing10','testing10','USER','ACTIVE','BIOLOGY','NO','6','5.0','4.0','4.0',1,1,1),(10014,'testing_now','testing_now','USER','ACTIVE','BIOLOGY','YES','1','0','0','0',1,1,1),(10015,'testregister','testregister','USER','ACTIVE','BIOLOGY','YES','1','0','0','0',1,1,1),(10016,'registertest','registertest','USER','ACTIVE','BIOLOGY','YES','1','0','0','0',1,1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_attempts`
--

DROP TABLE IF EXISTS `user_attempts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_attempts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `attempts` int(2) NOT NULL,
  `lastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `firstAttempt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_attempts`
--

LOCK TABLES `user_attempts` WRITE;
/*!40000 ALTER TABLE `user_attempts` DISABLE KEYS */;
INSERT INTO `user_attempts` VALUES (1,10001,1,'2018-01-28 15:43:04','2018-01-28 15:43:04'),(2,10001,1,'2018-01-28 19:46:46','2018-01-28 19:46:46'),(3,10008,1,'2018-02-26 17:34:01','2018-02-26 17:34:01'),(4,10008,1,'2018-02-26 17:45:13','2018-02-26 17:45:13'),(5,10005,1,'2018-03-11 10:27:18','2018-03-11 10:27:18'),(7,10014,1,'2018-06-24 16:30:25','2018-06-24 16:30:25');
/*!40000 ALTER TABLE `user_attempts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-21 17:16:51
