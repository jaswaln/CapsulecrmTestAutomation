Feature: Navigate to Url Account Settings Click on all link at left panel and perform operations and verify page headers

   @TestCase2
   Scenario Outline: Verify the page headers with Click on all link at left panel at account settings
        Given Navigate to URL1
        When Login with correct credentials1
        Then Click on account settings and verify page headers
        And Click on all links to the left panel , perform operations and verify page headers
        And Click on Appearance and upload image
        And Click on User : Add user and verify the same "<firstname>" "<lastname>" "<email>" "<username>"
        And Click on Opportunities and : Add new Milestone and verify the same "<mileStoneName>" "<description>" "<mileStoneProbability>" "<daysUntilStale>"
        And Click on Tracks : Add new Tracks and verify the same "<TrackName>" "<TagName>" "<TaskName>"
        And Click on Task Categories : Add new Categories and verify the same "<AddTaskName>"
        And Click on Tags : Add new milestones and verify the same "<AddTagName>"
        And Verify total number of configure buttons at Integrations
        And Close the browser
    Examples:
    |   firstname   |   lastname    |   email               |   username     | mileStoneName |   description         |   mileStoneProbability    |   daysUntilStale  |   TrackName   |  TagName      |   TaskName    |   AddTaskName |   AddTagName  |
    |   Ram         |   Sat         | RamSat@Gmail.com      |    jjjjjj110   |   NameZ       |   TestDescriptionK    |       20                  |       14          |  TestTrackB   |   TestTagB    |   TestTaskB   |   TestCallB    |   TestTagB    |
    |   Sat         |   Ram         | SatRam@Gmail.com      |    jjjjjj110   |   NameM       |   TestDescriptionC    |       20                  |       14          |  TestTrackC   |   TestTagC    |   TestTaskC   |   TestCallC    |   TestTagC    |
    |   Jhon        |   Rhon        | RohJho@Gmail.com      |    jjjjjj110   |   NameN       |   TestDescriptionD    |       20                  |       14          |  TestTrackD   |   TestTagD    |   TestTaskD   |   TestCallD    |   TestTagD    |