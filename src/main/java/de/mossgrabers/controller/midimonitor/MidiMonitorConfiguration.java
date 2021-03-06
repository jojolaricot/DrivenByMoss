// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2019
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.controller.midimonitor;

import de.mossgrabers.framework.configuration.AbstractConfiguration;
import de.mossgrabers.framework.configuration.IEnumSetting;
import de.mossgrabers.framework.configuration.ISettingsUI;
import de.mossgrabers.framework.controller.IValueChanger;
import de.mossgrabers.framework.daw.IHost;


/**
 * The configuration settings for the Midi Monitor implementation.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class MidiMonitorConfiguration extends AbstractConfiguration
{
    /** Setting for filtering system realtime. */
    public static final Integer FILTER_SYSTEM_REALTIME   = Integer.valueOf (50);

    private boolean             isFilterSystemRealtimeOn = false;


    /**
     * Constructor.
     *
     * @param host The DAW host
     * @param valueChanger The value changer
     */
    public MidiMonitorConfiguration (final IHost host, final IValueChanger valueChanger)
    {
        super (host, valueChanger);
    }


    /** {@inheritDoc} */
    @Override
    public void init (final ISettingsUI settingsUI)
    {
        final IEnumSetting filterSystemRealtimeSetting = settingsUI.getEnumSetting ("System Realtime", "Filter", ON_OFF_OPTIONS, ON_OFF_OPTIONS[0]);
        filterSystemRealtimeSetting.addValueObserver (value -> {
            this.isFilterSystemRealtimeOn = "On".equals (value);
            this.notifyObservers (FILTER_SYSTEM_REALTIME);
        });
    }


    /**
     * Is the filter for system realtime events enabled?
     *
     * @return True if the filter for system realtime events is enabled
     */
    public boolean isFilterSystemRealtimeEnabled ()
    {
        return this.isFilterSystemRealtimeOn;
    }
}
