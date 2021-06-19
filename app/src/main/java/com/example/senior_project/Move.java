package com.example.senior_project;

import java.io.Serializable;

public class Move implements Serializable{
    private String name;
    private String type;
    private String category;
    private int power;
    private int accuracy;
    private int pp;
    private String info;


    /*
	NAME:
	    Move
	SYNOPSIS:
	    Move object constructor
	DESCRIPTION:
        default move object constructor
	RETURNS:
	    none
*/
    public Move()
    {
        name = "None";
        type = "None";
        category = "None";
        power = 0;
        accuracy = 0;
        pp = 0;
        info = "None";
    }

/*
	NAME:
	    getName
	SYNOPSIS:
	    returns moves name
	DESCRIPTION:
	    returns the name of the move
	RETURNS:
	    name of move as a string
*/
    public String getName()
    {
        return name;
    }

    /*
	NAME:
	    getType
	SYNOPSIS:
	    returns a moves type
	DESCRIPTION:
	    returns the type of a specific move
	RETURNS:
	    the move's type as a string
*/
    public String getType()
    {
        return type;
    }

    /*
	NAME:
	    getCategory
	SYNOPSIS:
	    returns the category of a move
	DESCRIPTION:
	    returns if a move is physical, special, or status
	RETURNS:
	    returns string "physical" or "special" or "stastus"
*/
    public String getCategory()
    {
        return category;
    }

    /*
	NAME:
	    getPower
	SYNOPSIS:
	    returns a moves power
	DESCRIPTION:
	    retunrs power stat of a move
	RETURNS:
	    moves power as an int
*/
    public int getPower()
    {
        return power;
    }

    /*
	NAME:
	    getAccuracy
	SYNOPSIS:
	    returns a moves accuracy
	DESCRIPTION:
	    returns a moves accuracy stat
	RETURNS:
	    move's accuracy as an int
*/
    public int getAccuracy()
    {
        return accuracy;
    }

    /*
	NAME:
	    getPP
	SYNOPSIS:
	    returns move's pp stat
	DESCRIPTION:
	    returns a move's pp (number of times the move can be used)
	RETURNS:
	    pp of a move as an int
*/
    public int getPP()
    {
        return pp;
    }

    /*
	NAME:
	    getInfo
	SYNOPSIS:
	     returns info on the move
	DESCRIPTION:
	    return what status effect the move has
	RETURNS:
	    returns moves status effect as a string
*/
    public String getInfo()
    {
        return info;
    }

    /*
	NAME:
	    setName
	SYNOPSIS:
	    sets the Moves name
	DESCRIPTION:
	    takes inName and sets it to name
	RETURNS:
	    none
*/
    public void setName(String inName)
    {
        name = inName;
    }

    /*
	NAME:
	    setType
	SYNOPSIS:
	    sets the moves type
	DESCRIPTION:
	    takes inType and sets the move's type to that
	RETURNS:
	    none
*/
    public void setType(String inType)
    {
        type = inType;
    }

    /*
	NAME:
	    setCategory
	SYNOPSIS:
	    sets the move's category
	DESCRIPTION:
	    set the move as physical, special, or status
	RETURNS:
	    none
*/
    public void setCategory(String inCategory)
    {
        category = inCategory;
    }

    /*
	NAME:
	    setPower
	SYNOPSIS:
	    sets the moves power
	DESCRIPTION:
	    take inPower and sets it to the move's power
	RETURNS:
	    none
*/
    public void setPower(int inPower)
    {
        power = inPower;
    }

    /*
	NAME:
	    setAccuracy
	SYNOPSIS:
	    sets a move's accuracy
	DESCRIPTION:
	    take inAccuracy and sets it equal to the move's accuracy
	RETURNS:
	    none
*/
    public void setAccuracy(int inAccuracy)
    {
        accuracy = inAccuracy;
    }

    /*
	NAME:
	    setPP
	SYNOPSIS:
	    sets a move's pp
	DESCRIPTION:
	    takes inPP and sets it to the move's pp
	RETURNS:
	    none
*/
    public void setPP(int inPP)
    {
        pp = inPP;
    }

    /*
	NAME:
	    setInfo
	SYNOPSIS:
	    sets a move's info
	DESCRIPTION:
	    takes the inInfo and sets the move's info to reflect its status effect
	RETURNS:
	    none
*/
    public void setInfo(String inInfo)
    {
        info = inInfo;
    }
}
