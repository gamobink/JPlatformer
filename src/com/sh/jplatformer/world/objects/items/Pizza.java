package com.sh.jplatformer.world.objects.items;

import com.sh.jplatformer.world.WorldAudio;
import com.sh.jplatformer.world.WorldController;
import com.sh.jplatformer.world.map.MapObject;

/**
 * A {@code MapObject} item.
 * @author Stefan H�semann
 */

public class Pizza extends MapObject
{
	// Properties
	//===========
	private static final long serialVersionUID = 1L;
	
	// Constructor
	//============
	/**
	 * Constructs a new {@code MapObject}.
	 * @param newWorldController the {@code WorldController} to interact with.
	 */
	public Pizza( WorldController newWorldController )
	{
		// Super constructor
		//==================
		super( newWorldController );
		
		// Properties
		//===========
		name            = "Pizza";
		score           = 400;
		bounds.width    = 42f;
		bounds.height   = 46f;
		isBlockingSpace = false;
		ignoreGravity   = true;
		
		// Alignment
		//==========
		horizontalAlignment = ALIGN_CENTER;
		verticalAlignment = ALIGN_CENTER;
		
		// Init frames
		//============
		this.initFrames();
	}
	
	// onPlayerCollision
	//==================
	@Override
	public void onPlayerCollision()
	{
		// Set alive + add score
		//======================
		this.setAlive( false );
		worldController.addScore( score );
		worldController.addPopup( score + "",
		                          bounds.x + bounds.width  / 2f,
		                          bounds.y + bounds.height / 2f );
		
		// Play sound
		//===========
		WorldAudio.addCollectSound();
	}
}