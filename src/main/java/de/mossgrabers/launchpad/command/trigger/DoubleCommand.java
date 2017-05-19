// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.launchpad.command.trigger;

import de.mossgrabers.framework.ButtonEvent;
import de.mossgrabers.framework.Model;
import de.mossgrabers.framework.command.core.AbstractTriggerCommand;
import de.mossgrabers.framework.command.trigger.NewCommand;
import de.mossgrabers.framework.command.trigger.PlayCommand;
import de.mossgrabers.launchpad.LaunchpadConfiguration;
import de.mossgrabers.launchpad.controller.LaunchpadControlSurface;


/**
 * Command to duplicate an object (clip, track, ...) depending on the context.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class DoubleCommand extends AbstractTriggerCommand<LaunchpadControlSurface, LaunchpadConfiguration>
{
    private final PlayCommand<LaunchpadControlSurface, LaunchpadConfiguration> playCommand;
    private final NewCommand<LaunchpadControlSurface, LaunchpadConfiguration>  newCommand;


    /**
     * Constructor.
     *
     * @param model The model
     * @param surface The surface
     */
    public DoubleCommand (final Model model, final LaunchpadControlSurface surface)
    {
        super (model, surface);

        this.playCommand = new PlayCommand<> (model, surface);
        this.newCommand = new NewCommand<> (model, surface);
    }


    /** {@inheritDoc} */
    @Override
    public void executeNormal (final ButtonEvent event)
    {
        this.newCommand.executeNormal (event);
    }


    /** {@inheritDoc} */
    @Override
    public void executeShifted (final ButtonEvent event)
    {
        this.playCommand.executeNormal (event);
    }
}