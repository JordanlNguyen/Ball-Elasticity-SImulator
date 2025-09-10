# Flickering
This projects is being developed on both mac and windows. Initial code did not flicker on mac but does on Windows, this is due to the frame clearing and repaitning. To combat this issue,
we use theBufferedImage remove the automatic method clearing the frame and manually clearing the frame ourselfs.