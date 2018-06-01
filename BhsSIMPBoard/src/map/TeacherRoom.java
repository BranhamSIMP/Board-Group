package map;

import java.io.IOException; 

public class TeacherRoom {
	
	public static void main(String[] args) throws IOException{
		/*getPicture("1");
		getPicture("45");
		getPicture("9");
		getPicture("7");
		getPicture("22");
		getPicture("84");
		getPicture("Gym");
		getPicture("band room");*/
		//getPicture("Room 70");
	}
	
	
	/*
	 * takes in a room number/name and displays the teacher's picture
	 * Prints out "Invalid room number" if a room is empty
	 * Some teacher's pictures are still needed
	 */
	public static void getPicture(String room) throws IOException{
		TeacherPictures image = new TeacherPictures();
		try {
			if (!room.equals("Gym")) {
				room = room.substring(5, room.length()); 
			}
			
		}
		catch (Exception e) {
			room = "h";
		}
		if(Character.isDigit(room.charAt(0))) {
			
			int roomNum = Integer.parseInt(room);
			
			if((roomNum >= 1 && roomNum <=6) || (roomNum >= 8 && roomNum <= 10) ||
					(roomNum >= 13 && roomNum <= 18) || roomNum == 23 || roomNum == 42 
					|| roomNum == 45 || roomNum == 66) {
				//System.out.println("Invalid room number");
				image = new TeacherPictures("person.jpg");
			}
			else{
				switch(roomNum) {
				case 7:
					image = new TeacherPictures("CPlank.jpg");
					break;
				case 11:
					image = new TeacherPictures("person.jpg");
					break;
				case 12:
					image = new TeacherPictures("DM.jpg");
					break;
				case 19:
					image = new TeacherPictures("NN.jpg");
					break;
				case 20:
					image = new TeacherPictures("AW.jpg");
					break;
				case 21:
					image = new TeacherPictures("ME.jpg");
					break;
				case 22:
					image = new TeacherPictures("CF.jpg");
					image = new TeacherPictures("LS.jpg");
					break;
				case 24:
					image = new TeacherPictures("BA.jpg");
					break;
				case 25:
					image = new TeacherPictures("MV.jpg");
					break;
				case 26:
					image = new TeacherPictures("person.jpg");
					break;
				case 27:
					image = new TeacherPictures("CPonzio.jpg");
					break;
				case 28:
					image = new TeacherPictures("HA.jpg");
					break;
				case 29: 
					image = new TeacherPictures("DL.jpg");
					break;
				case 30: 
					image = new TeacherPictures("EK.jpg");
					image = new TeacherPictures("NH.jpg");
					break;
				case 31:
					image = new TeacherPictures("JBrouillet.jpg");
					image = new TeacherPictures("person.jpg");
					break;
				case 32:
					image = new TeacherPictures("person.jpg");
					image = new TeacherPictures("person.jpg");
					break;
				case 33:
					image = new TeacherPictures("person.jpg");
					break;
				case 34:
					image = new TeacherPictures("EW.jpg");
					break;
				case 35:
					image = new TeacherPictures("person.jpg");
					break;
				case 36:
					image = new TeacherPictures("CC.jpg");
					break;
				case 37:
					image = new TeacherPictures("IT.jpg");
					break;
				case 38:
					image = new TeacherPictures("TS.jpg");
					break;
				case 39:
					image = new TeacherPictures("BR.jpg");
					image = new TeacherPictures("NF.jpg");
					break;
				case 40:
					image = new TeacherPictures("MN.jpg");
					break;
				case 41:
					image = new TeacherPictures("MT.jpg");
					break;
				case 43:
					image = new TeacherPictures("AJ.jpg");
					break;
				case 44:
					image = new TeacherPictures("FV.jpg");
					break;
				case 46:
					image = new TeacherPictures("person.jpg");
					break;
				case 47:
					image = new TeacherPictures("MM.jpg");
					break;
				case 48:
					image = new TeacherPictures("KM.jpg");
					image = new TeacherPictures("person.jpg");
					break;
				case 49:
					image = new TeacherPictures("MR.jpg");
					break;
				case 50:
					image = new TeacherPictures("LG.jpg");
					break;
				case 51:
					image = new TeacherPictures("DMacKinnon.jpg");
					break;
				case 52:
					image = new TeacherPictures("DF.jpg");
					image = new TeacherPictures("EM.jpg");
					break;
				case 53:
					image = new TeacherPictures("TE.jpg");
					break;
				case 54:
					image = new TeacherPictures("JS.jpg");
					break;
				case 55:
					image = new TeacherPictures("JOzdinski.jpg");
					break;
				case 56:
					image = new TeacherPictures("BJ.jpg");
					break;
				case 57:
					image = new TeacherPictures("KS.jpg");
					break;
				case 58:
					image = new TeacherPictures("LP.jpg");
					break;
				case 59:
					image = new TeacherPictures("person.jpg");
					image = new TeacherPictures("EB.jpg");
					break;
				case 60:
					image = new TeacherPictures("CPrates.jpg");
					image = new TeacherPictures("person.jpg");
					break;
				case 61:
					image = new TeacherPictures("MP.jpg");
					break;
				case 62:
					image = new TeacherPictures("JF.jpg");
					break;
				case 63:
					image = new TeacherPictures("BW.jpg");
					break;
				case 64:
					image = new TeacherPictures("DW.jpg");
					break;
				case 65:
					image = new TeacherPictures("MD.jpg");
					break;
				case 67:
					image = new TeacherPictures("TM.jpg");
					break;
				case 68:
					image = new TeacherPictures("person.jpg");
					image = new TeacherPictures("person.jpg");
					break;
				case 69:
					image = new TeacherPictures("LMO.jpg");
					break;
				case 70:
					image = new TeacherPictures("MT.jpg");
					image = new TeacherPictures("BS.jpg");
					break;
				case 71:
					image = new TeacherPictures("ASH.jpg");
					break;
				case 72:
					image = new TeacherPictures("ST.jpg");
					break;
				case 73:
					image = new TeacherPictures("EM.jpg");
					image = new TeacherPictures("person.jpg");
					break;
				case 74:
					image = new TeacherPictures("KK.jpg");
					break;
				case 75:
					image = new TeacherPictures("LC.jpg");
					break;
				case 76:
					image = new TeacherPictures("DMackery.jpg");
					break;
				case 77:
					image = new TeacherPictures("JOverby.jpg");
					break;
				case 78:
					image = new TeacherPictures("KR.jpg");
					break;
				case 79:
					image = new TeacherPictures("DH.jpg");
					break;
				case 80:
					image = new TeacherPictures("SS.jpg");
					break;
				case 81:
					image = new TeacherPictures("AS.jpg");
					image = new TeacherPictures("LC.jpg");
					break;
				case 82:
					image = new TeacherPictures("JF.jpg");
					break;
				case 83:
					image = new TeacherPictures("JBrady.jpg");
					break;
				case 84:
					image = new TeacherPictures("RV.jpg");
					break;
				case 85:
					image = new TeacherPictures("MA.jpg");
					break;
				}
			}	
		}
		else {
			if(room.toLowerCase().equals("Gym")) {
				image = new TeacherPictures("EB.jpg");
				image = new TeacherPictures("person.jpg");
				image = new TeacherPictures("LA.jpg");
				image = new TeacherPictures("RS.jpg");
				image = new TeacherPictures("CHH.jpg");
				image = new TeacherPictures("CJ.jpg");
			
			}
			else if(room.toLowerCase().equals("band room")) {
				image = new TeacherPictures("DW.jpg");
			}
		}
	}
}
	

